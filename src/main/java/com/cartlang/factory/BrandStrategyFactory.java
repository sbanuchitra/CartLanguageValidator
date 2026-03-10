package com.cartlang.factory;
 
import com.cartlang.strategy.CartLanguageStrategy;
import com.cartlang.strategy.JloBeautyStrategy;
import com.cartlang.strategy.KindScienceStrategy;
import com.cartlang.strategy.SmileActivesStrategy;
import com.cartlang.strategy.TBFStrategy;
 
public class BrandStrategyFactory {
 
    public static CartLanguageStrategy getStrategy(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand is missing in Excel row");
        }
 
        switch (brand.trim().toLowerCase()) {
            case "smileactives":
                return new SmileActivesStrategy();
            case "kindscience":
                return new KindScienceStrategy();
            case "tbf":
                return new TBFStrategy();
            case "jlobeauty":
            	return new JloBeautyStrategy();
            default:
                throw new IllegalArgumentException("Unsupported brand: " + brand);
        }
    }
}