package org.dieschnittstelle.jee.esa.gae.client.services;

import org.fusesource.restygwt.client.Resource;
import org.fusesource.restygwt.client.RestServiceProxy;

import com.google.gwt.core.client.GWT;

public class Services {
   private static final String BASE_URL = "http://127.0.0.1:8888/rest";
   private static LoginResourceAsync loginResourceAsync;

   public static final LoginResourceAsync login() {
      if (loginResourceAsync == null) {
         loginResourceAsync = GWT.create(LoginResourceAsync.class);
         ((RestServiceProxy) loginResourceAsync).setResource(new Resource(BASE_URL + "/login"));
      }
      return loginResourceAsync;
   }
}
