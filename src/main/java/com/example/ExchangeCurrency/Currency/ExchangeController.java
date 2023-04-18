package com.example.ExchangeCurrency.Currency;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "api/v1/exchange")
public class ExchangeController {
    private final ExchangeService exchangeService;
    @Autowired
    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }
    @GetMapping(path = "/")
    public String getExchange(@RequestParam String from , //from whichCurrency
                                  @RequestParam String to, //to whichCurrency
                                  @RequestParam Double quantity) throws ParseException {
       return exchangeService.getExchange(from,to,quantity);
    }
}
