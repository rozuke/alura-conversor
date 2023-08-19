package com.alurachallenge2conversor.util;

import com.alurachallenge2conversor.constans.CountryConstant;
import com.alurachallenge2conversor.model.Currency;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class CallAPI {
    private final String apiKey = "54e094c2093355228502ce3204649cf9";

    public Currency getResponseCurrencyAPI() {
        String countries = CountryConstant.getCodeCurrencies();
        final String apiUrl = "http://api.exchangeratesapi.io/v1/latest?access_key=" + apiKey + "&symbols=" + countries;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(apiUrl).build();
        Currency currency = new Currency();
        try (Response response = client.newCall(request).execute()){
            String responseBody = response.body().string();
            Gson gson = new Gson();
            currency = gson.fromJson(responseBody, Currency.class);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return currency;
    }
}
