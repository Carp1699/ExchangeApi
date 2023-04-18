package com.example.ExchangeCurrency.Currency;

import org.json.simple.JSONObject;

public interface ExchangeServiceHelper {
    StringBuilder setUri(String from, String to);
    JSONObject getJSONObject(StringBuilder uri);

}
