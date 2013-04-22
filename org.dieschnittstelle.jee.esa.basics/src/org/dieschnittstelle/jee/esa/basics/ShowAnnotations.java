package org.dieschnittstelle.jee.esa.basics;

import java.lang.reflect.Field;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.basics.annotations.AnnotatedConsumableBuilder;
import org.dieschnittstelle.jee.esa.basics.annotations.ConsumableProxyImpl;
import org.dieschnittstelle.jee.esa.basics.annotations.DisplayAs;
import org.dieschnittstelle.jee.esa.basics.annotations.DisplayAs.DisplayType;

public class ShowAnnotations {
   protected static Logger logger = Logger.getLogger(ShowAnnotations.class);

   public static void main(String[] args) {
      // we initialise the collection
      ConsumableCollection collection = new ConsumableCollection("annotated/consumables.xml", new AnnotatedConsumableBuilder());
      // we load the contents into the collection
      collection.load();

      for (IConsumable consumable : collection.getConsumables()) {
         showAttributes(((ConsumableProxyImpl) consumable).getProxiedObject());
      }

      // we initialise a consumer
      Consumer consumer = new Consumer();
      // ... and let them consume
      consumer.consume(collection.getConsumables());
   }

   /*
    * †bungsaufgabe 2
    */
   private static void showAttributes(Object consumable) {
      System.out.println(getAttributesAsString(consumable.getClass(), consumable));
   }

   private static String getAttributesAsString(Class<?> c, Object consumable) {
      if (!c.isAssignableFrom(consumable.getClass())) {
         throw new IllegalArgumentException(c.getName() + "is not assignable from: " + consumable.getClass().getName());
      }
      StringBuilder sb = new StringBuilder(c.getSimpleName() + ": {");
      for (Field f : c.getDeclaredFields()) {
         f.setAccessible(true);
         try {
            sb.append(f.getType().getSimpleName() + getDisplayString(f, consumable) + ", ");
         } catch (IllegalArgumentException e) {
            e.printStackTrace();
         }
      }
      if (c.getSuperclass() != null && IConsumable.class.isAssignableFrom(c.getSuperclass())) {
         sb.append(getAttributesAsString(c.getSuperclass(), consumable));
      }
      sb.setLength(sb.length() - 2);
      sb.append("}");
      return sb.toString();
   }

   private static String getDisplayString(Field f, Object consumable) {
      try {
         if (f.isAnnotationPresent(DisplayAs.class)) {
            DisplayType displayType = f.getAnnotation(DisplayAs.class).displayType();
            switch (displayType) {
               case FIELD_NAME:
                  return "[" + f.getName() + "]";
               case VALUE:
                  return "[" + f.get(consumable).toString() + "]";
            }
         }
         return "[" + f.getName() + " : " + f.get(consumable).toString() + "]";
      } catch (IllegalArgumentException e) {
         e.printStackTrace();
         return "[" + f.getName() + "]";
      } catch (IllegalAccessException e) {
         e.printStackTrace();
         return "[" + f.getName() + "]";
      }
   }

}
