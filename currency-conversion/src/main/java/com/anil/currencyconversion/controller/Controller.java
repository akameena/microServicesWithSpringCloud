package com.anil.currencyconversion.controller;

import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.Soundbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.anil.currencyconversion.feignproxy.FeignProxy;
import com.anil.currencyconversion.model.CurrencyConversionData;

import feign.Feign;

@RestController
public class Controller {
	
	@Autowired
	private FeignProxy  feignProxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionData invokeCurrencyExchangeService(@PathVariable String from,@PathVariable String to,@PathVariable int quantity )
	{
		int total_amount=0;
		Map<String,String> uriVariables  = new HashMap<>();
		ResponseEntity<CurrencyConversionData> responseEntity = 
				new RestTemplate().getForEntity("http://localhost:8000/currency-echange/from/usd/to/inr", 
						CurrencyConversionData.class, uriVariables); //uri variable  use when we put some variable dynamically 
																	//in  out  uri
		
		CurrencyConversionData response = responseEntity.getBody();
		
		
		System.out.println("response is: "+response);
		
		total_amount = response.getConversionMultiple()*quantity;
		return  new CurrencyConversionData(response.getId(), response.getConversionMultiple(), response.getPort(), total_amount,"inr");
		
	}
	
	
	
	
	
	@GetMapping("/currency-converter-fegin/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionData invokeCurrencyExchangeServiceUsingFegin(@PathVariable String from,@PathVariable String to,@PathVariable int quantity )
	{
		int total_amount=0;
		
		CurrencyConversionData response = feignProxy.retriveCurrencyConversionData();
		
	
		System.out.println("response is: "+response);
		
		total_amount = response.getConversionMultiple()*quantity;
		return  new CurrencyConversionData(response.getId(), response.getConversionMultiple(), response.getPort(), total_amount,"inr");
		
	}
	

}
