package com.samuelsilva.something;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

/**
 * @author samuel.silva
 */

@SpringBootApplication
public class SomethingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SomethingApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("en", "US"));
	}
	
	@Configuration
	public static class MvcConfig extends WebMvcConfigurerAdapter {
		
		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addRedirectViewController("/", "/userregistration");
		}
	}
}
