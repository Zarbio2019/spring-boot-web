package com.programming.techie.springredditclone.util;

import lombok.experimental.UtilityClass;

/*
@UtilityClass:
  Marks the class as final.
  It generates a private no-arg constructor.
  It only allows the methods or fields to be static.
 */
@UtilityClass
public class Constants {
    public static final String ACTIVATION_EMAIL = "http://localhost:8080/api/auth/accountVerification";
}