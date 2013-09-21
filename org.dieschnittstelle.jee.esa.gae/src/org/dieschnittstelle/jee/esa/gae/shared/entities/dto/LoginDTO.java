package org.dieschnittstelle.jee.esa.gae.shared.entities.dto;

public class LoginDTO {
   private String name;
   private String password;

   public String getName() {
      return name;
   }

   public void setUserName(String name) {
      this.name = name;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

}
