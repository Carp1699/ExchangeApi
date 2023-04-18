package com.example.ExchangeCurrency.Currency;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
@Service
public class ExchangeHelper implements ExchangeServiceHelper{

    @Override
    public StringBuilder setUri(String from, String to) {
        StringBuilder urlBuilder = new StringBuilder();
      return urlBuilder.
                append("https://api.apilayer.com/exchangerates_data/latest?symbols=")
                .append(to)
                .append("&")
                .append("base=")
                .append(from);
    }

    @Override
    public JSONObject getJSONObject(StringBuilder uri) {
        WebClient.Builder builder = WebClient.builder();
        String jsonResponse =
                builder.build().get().uri(uri.toString()).header("apikey",System.getenv("API_EXCHANGE_KEY"))
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();
        Object obj = null;
        try {
            obj = new JSONParser().parse(jsonResponse);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return  (JSONObject) obj;

    }
}
