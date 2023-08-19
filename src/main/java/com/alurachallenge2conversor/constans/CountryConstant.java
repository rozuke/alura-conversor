package com.alurachallenge2conversor.constans;

import com.alurachallenge2conversor.model.Country;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryConstant {
    public static List<Country> countries = new ArrayList<>();

    public static void setCountries() {
        countries.add( new Country("ARS", "AR", "Peso argentino"));
        countries.add( new Country("AUD", "AU", "Dólar australiano"));
        countries.add( new Country("BOB", "BO", "Boliviano boliviano"));
        countries.add( new Country("BRL", "BR", "Real brasileño"));
        countries.add( new Country("CAD", "CA", "Dólar canadiense"));
        countries.add( new Country("CHF", "CH", "Franco suizo"));
        countries.add( new Country("CLP", "CL", "Peso chileno"));
        countries.add( new Country("CNY", "CN", "Yuan chino"));
        countries.add( new Country("COP", "CO", "Peso colombiano"));
        countries.add( new Country("EUR", "EU", "Euro"));
        countries.add( new Country("GBP", "GB", "Libra esterlina"));
        countries.add( new Country("INR", "IN", "Rupia india"));
        countries.add( new Country("JPY", "JP", "Yen japonés"));
        countries.add( new Country("KRW", "KR", "Won surcoreano"));
        countries.add( new Country("MXN", "MX", "Peso mexicano"));
        countries.add( new Country("NOK", "NO", "Corona noruega"));
        countries.add( new Country("NZD", "NZ", "Dólar neozelandés"));
        countries.add( new Country("PEN", "PE", "Sol peruano"));
        countries.add( new Country("PYG", "PY", "Guaraní paraguayo"));
        countries.add( new Country("RUB", "RU", "Rublo ruso"));
        countries.add( new Country("SEK", "SE", "Corona sueca"));
        countries.add( new Country("TRY", "TR", "Lira turca"));
        countries.add( new Country("USD", "US", "Dólar estadounidense"));
        countries.add( new Country("UYU", "UY", "Peso uruguayo"));
        countries.add( new Country("VEF", "VE", "Bolívar fuerte venezolano"));
    }

    public static String getCodeCurrencies() {
        StringBuilder countriesCode = new StringBuilder();
        for (Country code: countries) {
            countriesCode.append(code.getCodeCurrency() + ",");
        }
        return countriesCode.toString();
    }
}
