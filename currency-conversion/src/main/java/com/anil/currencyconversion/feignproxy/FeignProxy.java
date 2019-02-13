package com.anil.currencyconversion.feignproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.anil.currencyconversion.model.CurrencyConversionData;

//@FeignClient(name="currency-exchange-service",url="http://localhost:8000")  //in case ribbon client we no need url
//@FeignClient(name="currency-exchange-service")
@FeignClient(name="zull-api-gateway-server")
public interface FeignProxy {
	
	@GetMapping("currency-exchange-service/currency-echange/from/usd/to/inr")
	public CurrencyConversionData retriveCurrencyConversionData();
}
