package com.cartlang.model;

public class Product {

   private String sku;
   private String cartLanguage;

   public Product(String sku, String cartLanguage) {
       this.sku = sku;
       this.cartLanguage = cartLanguage;
   }

   public String getSku() {
       return sku;
   }

   public String getCartLanguage() {
       return cartLanguage;
   }
}