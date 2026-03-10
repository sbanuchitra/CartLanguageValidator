package com.cartlang.strategy;

import com.cartlang.model.OfferGrid;

public class KindScienceStrategy implements CartLanguageStrategy {

    @Override
    public String generateCartLanguage(OfferGrid offer) {

        String productType = offer.getType();
        String product = offer.getName();
        String price = offer.getPrice();
        String shipping = offer.getShipping();

        if (!price.startsWith("$")) {
            price = "$" + price;
        }

        if (!shipping.startsWith("$")) {
            shipping = "$" + shipping;
        }

        if (productType.equalsIgnoreCase("90days")) {

            return "I understand that three months after my first order is shipped, and then approximately every three months thereafter, "
                    + "I will continue to automatically receive a full size supply of Kind Science® "
                    + product
                    + " and will be charged three monthly payments of "
                    + price
                    + ", plus "
                    + shipping
                    + " shipping and handling charges and applicable sales tax, for each shipment until I cancel. "
                    + "I can choose to easily cancel by visiting kindscience.com/account.";
        }

        else if (productType.equalsIgnoreCase("30days")) {

            return "I understand that one month after my first order is shipped, and then approximately every three months thereafter, "
                    + "I will continue to automatically receive a full size supply of Kind Science® "
                    + product
                    + " and will be charged three monthly payments of "
                    + price
                    + ", plus "
                    + shipping
                    + " shipping and handling charges and applicable sales tax, for each shipment until I cancel. "
                    + "I can choose to easily cancel by visiting kindscience.com/account.";
        }

        else if (productType.equalsIgnoreCase("62days")) {

            return "I understand that two months after my first order is shipped, and then approximately every two months thereafter, "
                    + "I will continue to automatically receive a Kind Science® "
                    + product
                    + " and will be charged "
                    + price
                    + ", plus "
                    + shipping
                    + " shipping and handling charges and applicable sales tax, for each shipment until I cancel. "
                    + "I can choose to easily cancel by visiting kindscience.com/account.";
        }

        else {

            return "I understand that 21 days after my first order is shipped, and then approximately every two months thereafter, "
                    + "I will continue to automatically receive a Kind Science® "
                    + product
                    + " and will be charged "
                    + price
                    + ", plus "
                    + shipping
                    + " shipping and handling charges and applicable sales tax, for each shipment until I cancel. "
                    + "I can choose to easily cancel by visiting kindscience.com/account.";
        }
    }
}
