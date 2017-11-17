package br.com.felipe.poc.rest;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import br.com.felipe.poc.domain.Condutor;
import br.com.felipe.poc.domain.Habilitacao;
import br.com.felipe.poc.domain.Veiculo;

@Component
public class VeiculoREST extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		restConfiguration().host("localhost").port(3030);

		rest()
			.get("condutor").route()
				.to("direct:habilitacoes")
				.to("direct:veiculos")
				.to("direct:transforma");
		
		from("direct:habilitacoes")
			.to("http4://localhost:3030/habilitacoes/1?bridgeEndpoint=true")
				.setProperty("habilitacao", simple("${in.body}"));
		
		
		from("direct:veiculos")
			.to("http4://localhost:3030/veiculos/1?bridgeEndpoint=true")
				.setProperty("veiculo", simple("${in.body}"));
		
		from("direct:transforma")
			.process(exchange -> {
				Veiculo veiculo = exchange.getProperty("veiculo", Veiculo.class);
				Habilitacao habilitacao = exchange.getProperty("habilitacao", Habilitacao.class);
				
				Condutor condutor = new Condutor(habilitacao.getNome(), habilitacao.getRenach(), veiculo.getModelo(), veiculo.getCor());
				exchange.getIn().setBody(condutor);
			})
			.marshal().json(JsonLibrary.Jackson);
	}
}