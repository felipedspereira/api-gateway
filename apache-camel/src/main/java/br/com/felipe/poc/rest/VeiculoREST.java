package br.com.felipe.poc.rest;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class VeiculoREST extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		restConfiguration().host("localhost").port(3030);
		
		rest()
			.get("habilitacoes")
				.to("rest:get:habilitacoes/1?bridgeEndpoint=true");
	}

}