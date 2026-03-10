package com.cartlang.service;
 
import com.cartlang.factory.BrandStrategyFactory;
import com.cartlang.model.OfferGrid;
import com.cartlang.model.Product;
import com.cartlang.strategy.CartLanguageStrategy;
 
import java.util.Map;
 
public class ValidationService {
 
    public ValidationResult validate(OfferGrid offer, Map<String, Product> productMap) {
        CartLanguageStrategy strategy = BrandStrategyFactory.getStrategy(offer.getBrand());
        String expectedCartLanguage = strategy.generateCartLanguage(offer);
 
        Product product = productMap.get(offer.getSku());
 
        if (product == null) {
            return new ValidationResult(expectedCartLanguage, "Not Found", "Actual cart language not found for SKU");
        }
 
        String actualCartLanguage = product.getCartLanguage();
 
        if (expectedCartLanguage.trim().equalsIgnoreCase(actualCartLanguage.trim())) {
            return new ValidationResult(expectedCartLanguage, "Pass", "");
        }
 
        return new ValidationResult(
                expectedCartLanguage,
                "Fail",
                "Expected: " + expectedCartLanguage + " | Found: " + actualCartLanguage
        );
    }
}