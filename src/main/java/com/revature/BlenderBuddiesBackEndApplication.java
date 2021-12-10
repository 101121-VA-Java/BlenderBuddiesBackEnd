package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.revature.models.Fruityvice;
import com.revature.models.Spoonacular;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class BlenderBuddiesBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlenderBuddiesBackEndApplication.class, args);
		String url = "https://www.fruityvice.com/api/fruit/";
		RestTemplate rt = new RestTemplate();
		
		Fruityvice f = rt.getForObject(url + "6", Fruityvice.class);
		
		System.out.println(f);
		
//		String url1 ="https://api.spoonacular.com/food/ingredients/9003/information?amount=1&apiKey=e16c840ba6bc41799d1631c8121b5a4f";
//		Spoonacular s = rt.getForObject(url1, Spoonacular.class);
//		System.out.println(s);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

}
