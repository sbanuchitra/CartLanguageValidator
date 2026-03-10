package com.cartlang.util;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
 
public class ExcelUtil {
 
    public static int getColumnIndex(Row headerRow, String columnName) {
        for (Cell cell : headerRow) {
            if (getCellValue(cell).equalsIgnoreCase(columnName.trim())) {
                return cell.getColumnIndex();
            }
        }
        return -1;
    }
 
    public static String getCellValue(Cell cell) {
        return cell == null ? "" : cell.toString().trim();
    }
}
