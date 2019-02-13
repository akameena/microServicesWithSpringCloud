package com.anil.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.anil.currencyexchangeservice.service.ExchangeValues;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	@GetMapping("/currency-echange/from/{from}/to/{to}")
	public  ExchangeValues  currencyExchange(@PathVariable String from ,@PathVariable String to)
	{
		ExchangeValues exchangeValues = new ExchangeValues(1000L,from,to,BigDecimal.valueOf(65));
		exchangeValues.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		//exchangeValues.setPort(environment.getPropertySources());
		return exchangeValues;
	}

}
