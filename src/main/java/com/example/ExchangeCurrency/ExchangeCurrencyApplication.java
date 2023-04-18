package com.example.ExchangeCurrency;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@EnableConfigurationProperties(ConfigProperties.class)
public class ExchangeCurrencyApplication {
	private static final Logger logger = LogManager.getLogger(ExchangeCurrencyApplication.class);

	public static void main(String[] args) {
	SpringApplication.run(ExchangeCurrencyApplication.class, args);

	}
	@Bean
	ApplicationRunner applicationRunner(ConfigProperties configProperties,ApplicationContext context){
		return args -> {
			if(configProperties.isNames()){
				final AtomicInteger counter = new AtomicInteger(0);
				logger.info("**************** START: Total Bean Objects: {} ******************", context.getBeanDefinitionCount());

				Arrays.asList(context.getBeanDefinitionNames())
						.forEach(beanName -> {
							logger.info("{}) Bean Name: {} ", counter.incrementAndGet(), beanName);
						});
				logger.info("**************** END: Total Bean: {} ******************", context.getBeanDefinitionCount());
			}
		};
	}

	}


