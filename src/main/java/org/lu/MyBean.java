package org.lu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.Order;

@Order(value = 1)
@ConfigurationProperties(locations = "classpath:user.properties", ignoreUnknownFields = false, prefix = "user")
public class MyBean implements CommandLineRunner {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run(String... args) throws Exception {
		for (String s : args) {
			System.out.println(s);
		}
		System.out.println("second one");
	}

}
