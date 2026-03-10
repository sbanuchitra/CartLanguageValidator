package com.cartlang.service;

import com.cartlang.model.OfferGrid;
import com.cartlang.model.Product;
import com.cartlang.util.ExcelUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.*;

public class ExcelService {

    public Map<String, Product> loadProducts(Sheet productSheet) {

        Map<String, Product> productMap = new HashMap<>();

        Row header = productSheet.getRow(0);

        int skuCol = ExcelUtil.getColumnIndex(header, "Variant SKU");
        int langCol = ExcelUtil.getColumnIndex(header,
                "Variant Metafield: variant.cart_language [multi_line_text_field]");

        if (skuCol == -1 || langCol == -1) {
            throw new IllegalArgumentException(
                    "Required columns not found in products sheet");
        }

        for (int i = 1; i <= productSheet.getLastRowNum(); i++) {

            Row row = productSheet.getRow(i);
            if (row == null) continue;

            String sku = ExcelUtil.getCellValue(row.getCell(skuCol));
            String cartLanguage = ExcelUtil.getCellValue(row.getCell(langCol));

            if (!sku.isEmpty()) {
                productMap.put(sku, new Product(sku, cartLanguage));
            }
        }

        return productMap;
    }


    public List<OfferGrid> loadOfferGrid(Sheet offerGridSheet) {

        List<OfferGrid> offers = new ArrayList<>();

        Row header = offerGridSheet.getRow(0);

        int brandCol = ExcelUtil.getColumnIndex(header, "Brand");
        int typeCol = ExcelUtil.getColumnIndex(header, "Type");
        int skuCol = ExcelUtil.getColumnIndex(header, "SKU");

        if (skuCol == -1) {
            skuCol = ExcelUtil.getColumnIndex(header, "SKU id");
        }

        int nameCol = ExcelUtil.getColumnIndex(header, "Name");
        int bundleCol = ExcelUtil.getColumnIndex(header, "Bundle Name");
        int priceCol = ExcelUtil.getColumnIndex(header, "Price");
        int shippingCol = ExcelUtil.getColumnIndex(header, "Shipping");

        if (shippingCol == -1) {
            shippingCol = ExcelUtil.getColumnIndex(header, "Shipping price");
        }
        
        int categoryCol = ExcelUtil.getColumnIndex(header, "Category");

        // Only Brand and SKU are mandatory
        if (brandCol == -1 || skuCol == -1) {
            throw new IllegalArgumentException(
                    "Mandatory columns 'Brand' or 'SKU' not found in offergrid sheet");
        }

        for (int i = 1; i <= offerGridSheet.getLastRowNum(); i++) {

            Row row = offerGridSheet.getRow(i);
            if (row == null) continue;

            String brand = ExcelUtil.getCellValue(row.getCell(brandCol));
            String sku = ExcelUtil.getCellValue(row.getCell(skuCol));

            String type = typeCol != -1 ?
                    ExcelUtil.getCellValue(row.getCell(typeCol)) : "";

            String name = nameCol != -1 ?
                    ExcelUtil.getCellValue(row.getCell(nameCol)) : "";

            String bundleName = bundleCol != -1 ?
                    ExcelUtil.getCellValue(row.getCell(bundleCol)) : "";

            String price = priceCol != -1 ?
                    ExcelUtil.getCellValue(row.getCell(priceCol)) : "";

            String shipping = shippingCol != -1 ?
                    ExcelUtil.getCellValue(row.getCell(shippingCol)) : "";
            
            String category = categoryCol != -1
                    ? ExcelUtil.getCellValue(row.getCell(categoryCol))
                    : "";

            if (!sku.isEmpty()) {
                offers.add(new OfferGrid(
                        brand,
                        type,
                        sku,
                        name,
                        bundleName,
                        price,
                        shipping,
                        category
                ));
            }
        }

        return offers;
    }


    public int getOrCreateColumn(Row headerRow, Sheet sheet, String columnName) {

        int idx = ExcelUtil.getColumnIndex(headerRow, columnName);

        if (idx != -1) {
            return idx;
        }

        int newIndex = headerRow.getLastCellNum() == -1
                ? 0
                : headerRow.getLastCellNum();

        headerRow.createCell(newIndex).setCellValue(columnName);

        return newIndex;
    }
}