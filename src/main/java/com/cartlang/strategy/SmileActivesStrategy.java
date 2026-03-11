package com.cartlang.strategy;
 
import com.cartlang.model.OfferGrid;
 
public class SmileActivesStrategy implements CartLanguageStrategy {
 
    public String generateCartLanguage(OfferGrid offer) {
        String productType = safe(offer.getType());
        String bundleName = safe(offer.getBundleName());
        String price = ensureDollar(safe(offer.getPrice()));
        String shipping = ensureDollar(safe(offer.getShipping()));
 
        if (productType.equalsIgnoreCase("Singles") &&
                !bundleName.equalsIgnoreCase("Pro Whitening Gel (Small)")) {
            return "I understand that approximately three months after my first order is shipped, and then approximately every three months thereafter, "
                    + "I will continue to automatically receive a Smileactives® "
                    + bundleName + " and will be charged " + price + ", " + shipping + " for shipping and handling, "
                    + "and applicable sales tax, for each shipment until I cancel. I can choose to easily cancel by visiting smileactives.com/account.";
        } else if (productType.equalsIgnoreCase("Singles") &&
                bundleName.equalsIgnoreCase("Pro Whitening Gel (Small)")) {
            return "I understand that approximately one month after my first order is shipped, and then approximately every one month thereafter, "
                    + "I will continue to automatically receive a Smileactives® "
                    + bundleName + " and will be charged " + price + ", " + shipping + " for shipping and handling, "
                    + "and applicable sales tax, for each shipment until I cancel. I can choose to easily cancel by visiting smileactives.com/account.";
        } else if (productType.equalsIgnoreCase("30 days")) {
            return "I understand that approximately one month after my first order is shipped, and then approximately every three months thereafter, "
                    + "I will continue to automatically receive a full size supply of Smileactives® "
                    + bundleName + " and will be charged 3 monthly payments of " + price + ", " + shipping + " for shipping and handling, "
                    + "and applicable sales tax, for each shipment until I cancel. I can choose to easily cancel by visiting smileactives.com/account.";
        }
 
        return "I understand and agree that first shipment will be charged as three monthly payments of " + price + ". "
                + "And then approximately three months thereafter, I will automatically receive a full size supply of Smileactives® "
                + bundleName + " and will be charged 3 monthly payments of " + price + ", plus " + shipping + " shipping and handling "
                + "charges and applicable sales tax, for each shipment until I cancel. "
                + "I can choose to easily manage my kit or cancel by visiting smileactives.com/account or by calling (800) 207-8952.";
    }
 
    private String ensureDollar(String value) {
        return value.startsWith("$") ? value : "$" + value;
    }
 
    private String safe(String value) {
        return value == null ? "" : value.trim();
    }
}