package com.example.ExchangeCurrency.Currency;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.google.gson.Gson;
import io.netty.handler.codec.json.JsonObjectDecoder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

@Service
public class ExchangeService {
    private final ExchangeHelper helper;
    @Autowired
    public ExchangeService(ExchangeHelper exchangeHelper) {
        this.helper = exchangeHelper;
    }

    public String getExchange(String from, String to, Double quantity) throws ParseException {
       StringBuilder url = helper.setUri(from,to);
       JSONObject jsonObject = helper.getJSONObject(url);
        Map<String,Double> rates = ((Map<String,Double>) jsonObject.get("rates"));
        BigDecimal changeRate = new BigDecimal(rates.get(to));
        return changeRate.multiply(new BigDecimal(quantity)).setScale(4, RoundingMode.CEILING).toString();




    }
}
