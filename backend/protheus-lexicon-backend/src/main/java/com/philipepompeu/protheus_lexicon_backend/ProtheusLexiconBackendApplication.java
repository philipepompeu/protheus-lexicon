package com.philipepompeu.protheus_lexicon_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication()//(exclude = {DataSourceAutoConfiguration.class })
@EnableCaching
public class ProtheusLexiconBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProtheusLexiconBackendApplication.class, args);
	}

}
