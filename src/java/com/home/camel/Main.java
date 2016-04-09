package com.home.camel;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {

	public static void main(String[] args) throws Exception {
		basicCamelFiletoJMS();
	}
	
	public static void basicCamelFileOps() throws Exception
	{
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
	
	
	public static void basicCamelFiletoJMS() throws Exception
	{
		CamelContext camelContext = new DefaultCamelContext();
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		
		
		camelContext.addRoutes(new RouteBuilder() {
			public void configure() {
				from("file:/home/gauravrehan/Documents/temp/source?noop=true")
						.to("jms:queue:COM.HOME.CAMEL.REQUEST");
			}
		});
		
		camelContext.start();
		Thread.sleep(10000);
		camelContext.stop();
	}

}
