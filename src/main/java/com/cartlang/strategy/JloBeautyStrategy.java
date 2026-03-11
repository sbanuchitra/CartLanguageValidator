package com.cartlang.strategy;

import com.cartlang.model.OfferGrid;

public class JloBeautyStrategy implements CartLanguageStrategy {

    public String generateCartLanguage(OfferGrid offer) {

        String productType = offer.getType();
        String productName = offer.getName();
        String sku = offer.getSku();
        String price = offer.getPrice();
        String shipping = offer.getShipping();

        if (!price.startsWith("$")) {
            price = "$" + price;
        }

        if (!shipping.startsWith("$")) {
            shipping = "$" + shipping;
        }

        if (productType.equalsIgnoreCase("Singles")) {

            if (sku.equalsIgnoreCase("JL0126")) {

                return "I understand that approximately two months after my first order is shipped, and then approximately every two months thereafter, "
                        + "I will continue to automatically receive a JLO Beauty® " + productName
                        + " and will be charged " + price + ", " + shipping
                        + " for shipping and handling, and applicable sales tax, for each shipment until I cancel."
                        + " I can choose to easily cancel by visiting jlobeauty.com/account.";
            }

            return "I understand that approximately three months after my first order is shipped, and then approximately every three months thereafter, "
                    + "I will continue to automatically receive a JLO Beauty® " + productName
                    + " and will be charged " + price + ", " + shipping
                    + " for shipping and handling, and applicable sales tax, for each shipment until I cancel. "
                    + "I can choose to easily cancel by visiting jlobeauty.com/account.";
        }

        else if (productType.equalsIgnoreCase("30 days")) {

            return "I understand that approximately one month after my first order is shipped, and then approximately every three months thereafter, "
                    + "I will continue to automatically receive a full size supply of JLO Beauty® " + productName
                    + " and will be charged 3 monthly payments of " + price + ", " + shipping
                    + " for shipping and handling, and applicable sales tax, for each shipment until I cancel. "
                    + "I can choose to easily cancel by visiting jlobeauty.com/account.";
        }

        return "I understand that approximately three months after my first order is shipped, and then approximately every three months thereafter, "
                + "I will continue to automatically receive a JLO Beauty® " + productName
                + " and will be charged " + price + ", " + shipping
                + " for shipping and handling, and applicable sales tax, for each shipment until I cancel. "
                + "I can choose to easily cancel by visiting jlobeauty.com/account.";
    }
}
