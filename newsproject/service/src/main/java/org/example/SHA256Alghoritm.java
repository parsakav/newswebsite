package org.example;

  interface SHA256Alghoritm {
   String toHash(String txt);
   boolean checkHash(String txt, String hash);



}
