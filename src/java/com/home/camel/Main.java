package com.home.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {

	public static void main(String[] args) throws Exception {
		CamelContext camelContext = new DefaultCamelContext();
		camelContext.addRoutes(new RouteBuilder() {
			public void configure() {
				from("file:/home/gauravrehan/Documents/temp/source?noop=true")
						.to("file:/home/gauravrehan/Documents/temp/destination");
			}
		});
		
		camelContext.start();
		Thread.sleep(10000);
		camelContext.stop();
	}
}
