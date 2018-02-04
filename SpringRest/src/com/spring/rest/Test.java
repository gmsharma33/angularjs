package com.spring.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class Test {

	public Test() {
		System.out.println("Constructor");
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Hello World";
	}

}
