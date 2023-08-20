package com.alurachallenge2conversor.util;


import com.alurachallenge2conversor.model.Currency;

import java.text.DecimalFormat;

public class Util {

    public static String convertCurrency(double value, float baseInput, float baseOutput) {
        double result = (value * (1 / baseInput) * baseOutput);
        return String.format("%.4f", result).replace(",", ".");
    }
    public static float getRatesFromAPI(Currency currency, String code) {
        return switch (code) {
            case "ARS" -> currency.rates.ARS;
            case "AUD" -> currency.rates.AUD;
            case "BOB" -> currency.rates.BOB;
            case "BRL" -> currency.rates.BRL;
            case "CAD" -> currency.rates.CAD;
            case "CHF" -> currency.rates.CHF;
            case "CLP" -> currency.rates.CLP;
            case "CNY" -> currency.rates.CNY;
            case "COP" -> currency.rates.COP;
            case "EUR" -> currency.rates.EUR;
            case "GBP" -> currency.rates.GBP;
            case "INR" -> currency.rates.INR;
            case "JPY" -> currency.rates.JPY;
            case "KRW" -> currency.rates.KRW;
            case "MXN" -> currency.rates.MXN;
            case "NOK" -> currency.rates.NOK;
            case "NZD" -> currency.rates.NZD;
            case "PEN" -> currency.rates.PEN;
            case "PYG" -> currency.rates.PYG;
            case "RUB" -> currency.rates.RUB;
            case "SEK" -> currency.rates.SEK;
            case "TRY" -> currency.rates.TRY;
            case "USD" -> currency.rates.USD;
            case "UYU" -> currency.rates.UYU;
            case "VEF" -> currency.rates.VEF;
            default -> -1;
        };
    }
}
