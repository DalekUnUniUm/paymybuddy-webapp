package com.openclassroom.paymybuddywebapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

@SpringBootApplication
public class PaymybuddywebappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PaymybuddywebappApplication.class, args);
	}

	@Override
	public void run(String ...args){
		System.out.println("--------------------------");
		System.out.println("PAY MY BUDDY WEBAPP V0.3.1");
		System.out.println("--------------------------");

		/**RestTemplate restTemplate = new RestTemplate();

		String html = restTemplate.getForObject(url,String.class);

		System.out.println("htm = " + html);**/
	}
}
