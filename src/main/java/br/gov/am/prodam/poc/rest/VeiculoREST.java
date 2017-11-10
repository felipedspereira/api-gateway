package br.gov.am.prodam.poc.rest;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestOperationResponseMsgDefinition;
import org.springframework.stereotype.Component;

@Component
public class VeiculoREST extends RouteBuilder {
 
    @Override
    public void configure() throws Exception {
    	restConfiguration()
    		.component("restlet")
    		.host("10.10.3.18")
    		.port(8080)
    		.bindingMode(RestBindingMode.auto);
    	
    	RestOperationResponseMsgDefinition m = new RestOperationResponseMsgDefinition();
    	m.code(200);
    	m.setMessage("Operação realizada com sucesso");
    	
    	rest("/api")
    		.get("/transito/veiculos")
	    		.route()
	    			.to("class:br.gov.am.prodam.poc.rest.VeiculoREST?method=metodoTeste")
	    			.to("class:br.gov.am.prodam.poc.rest.VeiculoREST?method=metodoTeste2")
	    			.to("rest:get:scitweb-prodam-servicos/api/v1/selic?produces=text/xml");
	    		
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