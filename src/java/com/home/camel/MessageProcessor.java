package com.home.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageProcessor implements Processor {

	static final Logger logger = LoggerFactory.getLogger(MessageProcessor.class);
	@Override
	public void process(Exchange exchange) throws Exception {
		logger.info(exchange.getIn().getBody().toString());
	}

}
