package org.springbootcamp.spike.vaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VaadinApplication {

	@SpringUI
	@Theme("valo")
	public class MyVaadinUI extends UI {

		@Autowired
		private Greeter greeter;

		@Override
		protected void init(VaadinRequest vaadinRequest) {
			setContent(new Label(greeter.sayHello()));
		}
	}

	@SpringComponent
	@UIScope
	public class Greeter {
		public String sayHello() {
			return "Hello from bean " + toString();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(VaadinApplication.class, args);
	}
}
