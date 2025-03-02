package com.vedant.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HomeController {

	@GetMapping
	public String homeContrillerHandler() {
		return "Hello i am vedant and i am started learing spring boot";	
	}
	
	@GetMapping("/author")
	public String author()
	{
		return "Hello i am vedant and i am author of this program";
	}
}
