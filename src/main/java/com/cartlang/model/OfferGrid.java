package com.cartlang.model;

public class OfferGrid {

   private String brand;
   private String type;
   private String sku;
   private String name;
   private String bundleName;
   private String price;
   private String shipping;
   private String category;
   

   public OfferGrid(String brand, String type, String sku, String name,
                    String bundleName, String price, String shipping, String category) {

       this.brand = brand;
       this.type = type;
       this.sku = sku;
       this.name = name;
       this.bundleName = bundleName;
       this.price = price;
       this.shipping = shipping;
       this.category = category;
   }

   public String getBrand() { return brand; }
   public String getType() { return type; }
   public String getSku() { return sku; }
   public String getName() { return name; }
   public String getBundleName() { return bundleName; }
   public String getPrice() { return price; }
   public String getShipping() { return shipping; }
   public String getCategory() { return category; }
}

