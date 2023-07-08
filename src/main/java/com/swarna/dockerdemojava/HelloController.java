package com.swarna.dockerdemojava;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(path = "/")
	public String helloWorld() {
		return "{\"message\":\"Hello from Docker Demo Java v1\"}";
	}
}
