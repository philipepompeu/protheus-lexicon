package com.philipepompeu.protheus_lexicon_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()//(exclude = {DataSourceAutoConfiguration.class })
public class ProtheusLexiconBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProtheusLexiconBackendApplication.class, args);
	}

}
