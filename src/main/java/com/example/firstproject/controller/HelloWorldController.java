package com.example.firstproject.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldController {
	
	@Value("${app.smpt.name}")
	private String smtpName;
		
	@RequestMapping("/hello")
	public String hello(){				
		return "Hello Modern Students:"+smtpName;	
		}
}
