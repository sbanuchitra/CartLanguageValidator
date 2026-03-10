package com.cartlang.service;
 
public class ValidationResult {
    private final String expectedCartLanguage;
    private final String result;
    private final String mismatchInfo;
 
    public ValidationResult(String expectedCartLanguage, String result, String mismatchInfo) {
        this.expectedCartLanguage = expectedCartLanguage;
        this.result = result;
        this.mismatchInfo = mismatchInfo;
    }
 
    public String getExpectedCartLanguage() {
        return expectedCartLanguage;
    }
 
    public String getResult() {
        return result;
    }
 
    public String getMismatchInfo() {
        return mismatchInfo;
    }
}