package br.com.bolsaapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/main" )
public class HealthCheckController {

	@GetMapping
	public String healthCheck() {
		return "OK";

	}

}
