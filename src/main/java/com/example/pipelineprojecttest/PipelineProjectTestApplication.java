package com.example.pipelineprojecttest;

import com.example.pipelineprojecttest.models.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PipelineProjectTestApplication {

	private static final Logger log = LoggerFactory.getLogger(PipelineProjectTestApplication.class);


	public static void main(String[] args) {

		SpringApplication.run(PipelineProjectTestApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject("https://quoters.apps.pcfone.io/api/random",
						Quote.class);
			log.info(quote.toString());
			System.out.println(quote.toString());
		};
	}
}
