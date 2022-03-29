package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		HelloWorld helloWorld = new HelloWorld();
		helloWorld.helloPrinter();
	}
@Controller
	class KsiazkaControler {

}

}
