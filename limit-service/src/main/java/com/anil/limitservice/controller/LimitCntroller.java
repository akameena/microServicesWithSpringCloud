package com.anil.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anil.limitservice.config.ConfigLimit;
import com.anil.limitservice.model.Limit;

@RestController
public class LimitCntroller {
	
	@Autowired
	private ConfigLimit configLimit;
	@GetMapping("/limit")
	public Limit returnLimit()
	{
		
		
		return new Limit(configLimit.getMinimum() ,configLimit.getMaximum());
		
	}

}
