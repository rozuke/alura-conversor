package com.alurachallenge2conversor.model;

public class Country {

    private String codeCurrency;
    private String codeFlag;

    public String getCodeFlag() {
        return codeFlag;
    }

    public Country(String codeCurrency, String codeFlag, String countryNameCurrency) {
        this.codeCurrency = codeCurrency;
        this.codeFlag = codeFlag;
        this.countryNameCurrency = countryNameCurrency;
    }

    public void setCodeFlag(String codeFlag) {
        this.codeFlag = codeFlag;
    }

    private String countryNameCurrency;

    public String getCodeCurrency() {
        return codeCurrency;
    }

    public void setCodeCurrency(String codeCurrency) {
        this.codeCurrency = codeCurrency;
    }

    public String getCountryNameCurrency() {
        return countryNameCurrency;
    }

    public void setCountryNameCurrency(String countryNameCurrency) {
        this.countryNameCurrency = countryNameCurrency;
    }

    @Override
    public String toString() {
        return codeCurrency + " - " + countryNameCurrency;
    }
}
