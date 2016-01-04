package org.lu;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication(scanBasePackages = { "org.lu" })
@Import(value = { MyBean1.class })
@EnableConfigurationProperties(value = {MyBean.class})
public class Example {

	@Autowired
	ApplicationArguments arg;

	@Autowired
	MyBean bean;

	@Autowired
	MyBean1 bean1;

	@RequestMapping("/")
	String home() {
		System.out.println(arg);
		System.out.println(bean.getName());
		bean1.sayhi();
		return "Hello World!";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication app = new SpringApplication(Example.class);
		app.setBanner(new Banner() {
			@Override
			public void printBanner(Environment environment,
					Class<?> sourceClass, PrintStream out) {
				System.out.println(sourceClass);
				out.println("aaaaaaaaaa");
				out.println("aaa    aaa");
				out.println("aaaaaaaaaa");
			}

		});
		app.run(args);
	}

	private void addListeners(SpringApplication app) {
		List<ApplicationListener<ApplicationStartedEvent>> listeners = new ArrayList<ApplicationListener<ApplicationStartedEvent>>();
		listeners.add(new ApplicationListener<ApplicationStartedEvent>() {
			@Override
			public void onApplicationEvent(ApplicationStartedEvent arg0) {
				System.out.println(arg0.getSpringApplication()
						.getInitializers());
			}

		});
		app.setListeners(listeners);
	}
}
