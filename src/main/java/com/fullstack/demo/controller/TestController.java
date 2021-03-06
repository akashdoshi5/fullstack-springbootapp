package com.fullstack.demo.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.demo.model.Greeting;

@RestController
public class TestController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
    
	@GetMapping("/test")
	@ResponseBody
	public Greeting sayHello (@RequestParam(name="name",required=false,defaultValue="Akash")String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
