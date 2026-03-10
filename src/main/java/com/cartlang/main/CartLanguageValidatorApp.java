package com.cartlang.main;
 
import com.cartlang.model.OfferGrid;
import com.cartlang.model.Product;
import com.cartlang.service.ExcelService;
import com.cartlang.service.ValidationResult;
import com.cartlang.service.ValidationService;
 
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
 
public class CartLanguageValidatorApp {
 
    public static void main(String[] args) {
 
        ExcelService excelService = new ExcelService();
        ValidationService validationService = new ValidationService();
 
        try (
 
                InputStream fis = CartLanguageValidatorApp.class
                        .getClassLoader()
                        .getResourceAsStream("input/cart_language_input.xlsx");
 
                XSSFWorkbook inputWorkbook = new XSSFWorkbook(fis)
 
        ) {
 
            if (fis == null) {
                throw new RuntimeException("Input Excel file not found in resources/input/");
            }
 
            Sheet offerGridSheet = inputWorkbook.getSheet("offergrid");
            Sheet productSheet = inputWorkbook.getSheet("products");
 
            if (offerGridSheet == null || productSheet == null) {
                throw new RuntimeException("Required sheets 'offergrid' or 'products' not found.");
            }
 
            Map<String, Product> productMap = excelService.loadProducts(productSheet);
            List<OfferGrid> offers = excelService.loadOfferGrid(offerGridSheet);
 
            // Create Output Workbook
            XSSFWorkbook outputWorkbook = new XSSFWorkbook();
            XSSFSheet outputSheet = outputWorkbook.createSheet("CartLanguageValidation");
 
            // Header
            Row header = outputSheet.createRow(0);
 
            header.createCell(0).setCellValue("Brand");
            header.createCell(1).setCellValue("SKU");
            header.createCell(2).setCellValue("Name");
            header.createCell(3).setCellValue("Pricing");
            header.createCell(4).setCellValue("Shipping");
            header.createCell(5).setCellValue("Expected Cart Language");
            header.createCell(6).setCellValue("Result");
            header.createCell(7).setCellValue("Mismatch Info");
 
            // Style for Fail rows
            CellStyle failStyle = outputWorkbook.createCellStyle();
            failStyle.setFillForegroundColor(IndexedColors.ROSE.getIndex());
            failStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
 
            int rowIndex = 1;
 
            for (OfferGrid offer : offers) {
 
                ValidationResult result = validationService.validate(offer, productMap);
 
                Row row = outputSheet.createRow(rowIndex++);
 
                row.createCell(0).setCellValue(offer.getBrand());
                row.createCell(1).setCellValue(offer.getSku());
                row.createCell(2).setCellValue(offer.getName());
                row.createCell(3).setCellValue(offer.getPrice());
                row.createCell(4).setCellValue(offer.getShipping());
                row.createCell(5).setCellValue(result.getExpectedCartLanguage());
                row.createCell(6).setCellValue(result.getResult());
                row.createCell(7).setCellValue(result.getMismatchInfo());
 
                // Color row if Fail
                if ("Fail".equalsIgnoreCase(result.getResult())) {
                    for (int c = 0; c <= 7; c++) {
                        row.getCell(c).setCellStyle(failStyle);
                    }
                }
            }
 
            // Autosize columns
            for (int i = 0; i < 8; i++) {
                outputSheet.autoSizeColumn(i);
            }
 
            // Save output file
            try (FileOutputStream fos =
                         new FileOutputStream("cart_language_validation_output.xlsx")) {
 
                outputWorkbook.write(fos);
            }
 
            outputWorkbook.close();
 
            System.out.println("Cart Language validation completed.");
            System.out.println("Output file generated: cart_language_validation_output.xlsx");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}