package com.github.fabriciolfj.exceptions.enums;

import java.util.ResourceBundle;


public enum Errors {

    ERROR_1;

   public String toMessage() {
       var bundle = ResourceBundle.getBundle("messages/exceptions");
       return bundle.getString(this.name() + ".message");
   }
}
