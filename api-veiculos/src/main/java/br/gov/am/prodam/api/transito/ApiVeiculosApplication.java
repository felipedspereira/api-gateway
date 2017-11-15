package br.gov.am.prodam.api.transito;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.gov.am.prodam.api.transito.rest.HabilitacaoREST;
import br.gov.am.prodam.api.transito.rest.VeiculoREST;

@SpringBootApplication
public class ApiVeiculosApplication extends ResourceConfig {

	public ApiVeiculosApplication() {
		registerEndpoints();
	}

	private void registerEndpoints() {
		register(VeiculoREST.class);
		register(HabilitacaoREST.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiVeiculosApplication.class, args);
	}

}