package org.example;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class SHA256AlghoritmImpl implements SHA256Alghoritm {
  @Override
  public String toHash(String txt) {


    /*  String sha256 = Hashing.sha256()
              .hashString(txt, StandardCharsets.UTF_8)
              .toString();
      return sha256;*/
      return txt;
  }

  @Override
  public boolean checkHash(String txt, String hash) {
/*      System.out.println(txt);
      System.out.println(hash);
      System.out.println(hash.length());
      System.out.println(txt.length());
   return txt.trim().equals(hash.trim());*/
      return txt.equals(hash);
  }
 }
