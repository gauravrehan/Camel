package com.home.camel;

import org.apache.camel.CamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.camel.main.Main;

public class SpringMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CamelContext camelContext = appContext.getBean("camelContext", CamelContext.class);
		Main m = new Main();
		m.getCamelContexts().add(camelContext);
		m.run();
	}
}
