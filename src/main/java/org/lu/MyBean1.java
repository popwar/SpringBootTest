package org.lu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Configuration
@Profile("dev")
public class MyBean1 {

	@Value("${user}")
	private String name;

	public void sayhi() {
		System.out.println("Hello " + name);
	}

}
