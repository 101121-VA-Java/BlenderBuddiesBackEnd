package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.web.client.RestTemplate;

import com.revature.models.Fruityvice;
=======
>>>>>>> main

@SpringBootApplication
public class BlenderBuddiesBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlenderBuddiesBackEndApplication.class, args);
<<<<<<< HEAD
		String url = "https://www.fruityvice.com/api/fruit/";

		RestTemplate rt = new RestTemplate();

		Fruityvice f = rt.getForObject(url + "6", Fruityvice.class);

		System.out.println(f);
=======
>>>>>>> main
	}

}
