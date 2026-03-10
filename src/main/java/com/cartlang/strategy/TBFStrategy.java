package com.cartlang.strategy;

import com.cartlang.model.OfferGrid;

public class TBFStrategy implements CartLanguageStrategy {

    @Override
    public String generateCartLanguage(OfferGrid offer) {

        String productType = offer.getType();
        String productname = offer.getName();
        String price = offer.getPrice();
        String shipping = offer.getShipping();
        String category = offer.getCategory();

        if (!price.startsWith("$")) {
            price = "$" + price;
        }

        if (!shipping.startsWith("$")) {
            shipping = "$" + shipping;
        }

        if ((productType.equalsIgnoreCase("Singles")) && (category.equalsIgnoreCase("YT"))) {

            return "I understand that approximately three months after my first order is shipped, and then approximately every three months thereafter, "
                    + "I will continue to automatically receive a Youthful Essence™ " + productname + " and will be charged "
                    + price + ", " + shipping + " for shipping and handling charges, and applicable sales tax, for each shipment until I cancel. "
                    + "I can choose to easily cancel by visiting thebodyfirm.com/account.";
        }

        else if ((productType.equalsIgnoreCase("Singles")) && (category.equalsIgnoreCase("ES"))) {

            return "I understand that approximately three months after my first order is shipped, and then approximately every three months thereafter, "
                    + "I will continue to automatically receive a Essentials " + productname + " and will be charged "
                    + price + ", " + shipping + " for shipping and handling charges, and applicable sales tax, for each shipment until I cancel. "
                    + "I can choose to easily cancel by visiting thebodyfirm.com/account.";
        }

        else if ((productType.equalsIgnoreCase("Singles-one")) && (category.equalsIgnoreCase("YT"))) {

            return "I understand that approximately one month after my first order is shipped, and then approximately every one month thereafter, "
                    + "I will continue to automatically receive a Youthful Essence™ " + productname + " and will be charged "
                    + price + ", " + shipping + " for shipping and handling charges, and applicable sales tax, for each shipment until I cancel. "
                    + "I can choose to easily cancel by visiting thebodyfirm.com/account.";
        }

        else if ((productType.equalsIgnoreCase("Singles")) && (category.equalsIgnoreCase("CS"))) {

            return "I understand that approximately three months after my first order is shipped, and then approximately every three months thereafter, "
                    + "I will continue to automatically receive a Crepe Erase® " + productname + " and will be charged "
                    + price + ", " + shipping + " for shipping and handling charges, and applicable sales tax, for each shipment until I cancel. "
                    + "I can choose to easily cancel by visiting thebodyfirm.com/account.";
        }

        else if ((productType.equalsIgnoreCase("Upgrade")) && (category.equalsIgnoreCase("ES"))) {

            return "I understand that approximately one month after my first order is shipped, and then approximately every three months thereafter, "
                    + "I will continue to automatically receive a full size supply of Essentials " + productname
                    + " and will be charged 3 monthly payments of "
                    + price + ", " + shipping + " for shipping and handling charges, and applicable sales tax, for each shipment until I cancel. "
                    + "I can choose to easily cancel by visiting thebodyfirm.com/account.";
        }

        else if ((productType.equalsIgnoreCase("30 days")) && (category.equalsIgnoreCase("YT"))) {

            return "I understand that approximately one month after my first order is shipped, and then approximately every three months thereafter, "
                    + "I will continue to automatically receive a full size supply of Youthful Essence™ " + productname
                    + " and will be charged 3 monthly payments of "
                    + price + ", " + shipping + " for shipping and handling charges, and applicable sales tax, for each shipment until I cancel. "
                    + "I can choose to easily cancel by visiting thebodyfirm.com/account.";
        }

        else if ((productType.equalsIgnoreCase("30 days")) && (category.equalsIgnoreCase("CS"))) {

            return "I understand that approximately one month after my first order is shipped, and then approximately every three months thereafter, "
                    + "I will continue to automatically receive a full size supply of Crepe Erase® " + productname
                    + " and will be charged 3 monthly payments of "
                    + price + ", " + shipping + " for shipping and handling charges, and applicable sales tax, for each shipment until I cancel. "
                    + "I can choose to easily cancel by visiting thebodyfirm.com/account.";
        }

        else if ((productType.equalsIgnoreCase("90 days")) && (category.equalsIgnoreCase("YT"))) {

            return "I understand that today’s shipment will be charged as 3 monthly payments of "
                    + price
                    + " and then approximately every three months thereafter, I will continue to automatically receive a full size supply of Youthful Essence™ "
                    + productname + " and will be charged 3 monthly payments of "
                    + price + ", " + shipping
                    + " for shipping and handling charges, and applicable sales tax, for each shipment until I cancel. "
                    + "I can choose to easily cancel by visiting thebodyfirm.com/account.";
        }

        return "I understand that today’s shipment will be charged as 3 monthly payments of "
                + price
                + " and then approximately every three months thereafter, I will continue to automatically receive a full size supply of Crepe Erase® "
                + productname + " and will be charged 3 monthly payments of "
                + price + ", " + shipping
                + " for shipping and handling charges, and applicable sales tax, for each shipment until I cancel. "
                + "I can choose to easily cancel by visiting thebodyfirm.com/account.";
    }
}