package br.com.felipe.poc.rest;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class VeiculoREST extends RouteBuilder {
 
    @Override
    public void configure() throws Exception {
    	restConfiguration()
    		.component("restlet")
    		.host("localhost")
    		.port(8080)
    		.apiContextPath("/api-doc")
    		.apiProperty("api.title", "Api testes do felipe")
    		.bindingMode(RestBindingMode.auto);
    	
    	rest("/api")
    		.get("/transito/veiculos")
	    		.route()
	    			.to("class:br.com.felipe.poc.rest.VeiculoREST?method=metodoTeste")
	    			.to("class:br.com.felipe.poc.rest.VeiculoREST?method=metodoTeste2")
    		.endRest();
	    		
    }
    
    public String metodoTeste() {
    	System.out.println("Chamou aqui");
    	return "OK OK OK ";
    }
    
    public String metodoTeste2() {
    	System.out.println("Chamou metodo teste 2");
    	return "OK OK OK ";
    }
}