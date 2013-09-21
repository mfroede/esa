package org.dieschnittstelle.jee.esa.android;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.concurrent.atomic.AtomicInteger;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.google.android.gms.gcm.GoogleCloudMessaging;

public class MainActivity extends Activity {

   public static final String EXTRA_MESSAGE = "message";
   public static final String PROPERTY_REG_ID = "org.dieschnittstelle.jee.esa.android.cns";
   private static final String PROPERTY_APP_VERSION = "appVersion";
   private static final String PROPERTY_ON_SERVER_EXPIRATION_TIME = "onServerExpirationTimeMs";

   public static final long REGISTRATION_EXPIRY_TIME_MS = 1000 * 3600 * 24 * 7;
   static final String LOG_TAG = MainActivity.class.getName();
   String SENDER_ID = "74013628621";
   GoogleCloudMessaging gcm;
   AtomicInteger msgId = new AtomicInteger();
   SharedPreferences prefs;
   Context context;

   String regid;

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      setContentView(R.layout.main);

      context = getApplicationContext();
      regid = getRegistrationId(context);

      if (regid.length() == 0) {
         registerBackground();
      } else {
         registerWithServer();
      }
      gcm = GoogleCloudMessaging.getInstance(this);
   }

   /**
    * Registers the application with GCM servers asynchronously.
    * <p>
    * Stores the registration id, app versionCode, and expiration time in the
    * application's shared preferences.
    */
   private void registerBackground() {
      new AsyncTask<Void, Void, String>() {

         @Override
         protected String doInBackground(Void... params) {
            String msg = "";
            try {
               if (gcm == null) {
                  gcm = GoogleCloudMessaging.getInstance(context);
               }
               regid = gcm.register(SENDER_ID);
               msg = "Device registered, registration id=" + regid;

               setRegistrationId(context, regid);

               registerWithServer();

            } catch (IOException ex) {
               msg = "Error :" + ex.getMessage();
            }
            return msg;
         }

         @Override
         protected void onPostExecute(String msg) {
            Toast.makeText(MainActivity.this, "GCM Registration successful: " + msg, Toast.LENGTH_SHORT).show();
         }

      }.execute(null, null, null);

   }

   /**
    * Stores the registration id, app versionCode, and expiration time in the
    * application's {@code SharedPreferences}.
    * 
    * @param context
    *           application's context.
    * @param regId
    *           registration id
    */
   private void setRegistrationId(Context context, String regId) {
      final SharedPreferences prefs = getGCMPreferences(context);
      int appVersion = getAppVersion(context);
      Log.v(LOG_TAG, "Saving regId on app version " + appVersion);
      SharedPreferences.Editor editor = prefs.edit();
      editor.putString(PROPERTY_REG_ID, regId);
      editor.putInt(PROPERTY_APP_VERSION, appVersion);
      long expirationTime = System.currentTimeMillis() + REGISTRATION_EXPIRY_TIME_MS;

      Log.v(LOG_TAG, "Setting registration expiry time to " + new Timestamp(expirationTime));
      editor.putLong(PROPERTY_ON_SERVER_EXPIRATION_TIME, expirationTime);
      editor.commit();
   }

   /**
    * Gets the current registration id for application on GCM service.
    * <p>
    * If result is empty, the registration has failed.
    * 
    * @return registration id, or empty string if the registration is not
    *         complete.
    */
   private String getRegistrationId(Context context) {
      final SharedPreferences prefs = getGCMPreferences(context);
      String registrationId = prefs.getString(PROPERTY_REG_ID, "");
      if (registrationId.length() == 0) {
         Log.v(LOG_TAG, "Registration not found.");
         return "";
      }
      // check if app was updated; if so, it must clear registration id to
      // avoid a race condition if GCM sends a message
      int registeredVersion = prefs.getInt(PROPERTY_APP_VERSION, Integer.MIN_VALUE);
      int currentVersion = getAppVersion(context);
      if (registeredVersion != currentVersion || isRegistrationExpired()) {
         Log.v(LOG_TAG, "App version changed or registration expired.");
         return "";
      }
      return registrationId;
   }

   /**
    * @return Application's {@code SharedPreferences}.
    */
   private SharedPreferences getGCMPreferences(Context context) {
      return getSharedPreferences(MainActivity.class.getSimpleName(), Context.MODE_PRIVATE);
   }

   /**
    * @return Application's version code from the {@code PackageManager}.
    */
   private static int getAppVersion(Context context) {
      try {
         PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
         return packageInfo.versionCode;
      } catch (NameNotFoundException e) {
         // should never happen
         throw new RuntimeException("Could not get package name: " + e);
      }
   }

   /**
    * Checks if the registration has expired.
    * 
    * <p>
    * To avoid the scenario where the device sends the registration to the
    * server but the server loses it, the app developer may choose to
    * re-register after REGISTRATION_EXPIRY_TIME_MS.
    * 
    * @return true if the registration has expired.
    */
   private boolean isRegistrationExpired() {
      final SharedPreferences prefs = getGCMPreferences(context);
      // checks if the information is not stale
      long expirationTime = prefs.getLong(PROPERTY_ON_SERVER_EXPIRATION_TIME, -1);
      return System.currentTimeMillis() > expirationTime;
   }

   private void registerWithServer() {
      String baseUrl = "http://dieschnittstelle2013.appspot.com/rest/campaignnotifications/register/";
      String url = baseUrl + getRegistrationId(MainActivity.this);
      AQuery aq = new AQuery(MainActivity.this);
      aq.ajax(url, String.class, new AjaxCallback<String>() {

         @Override
         public void callback(String url, String s, AjaxStatus status) {
            if (s != null) {
               Toast.makeText(MainActivity.this, "GCM Registration successful: " + s, Toast.LENGTH_SHORT).show();
            } else {
               Toast.makeText(MainActivity.this, status.toString(), Toast.LENGTH_LONG).show();
            }
         }

      });
   }
}
