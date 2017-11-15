package br.gov.am.prodam.api.transito.rest;

import java.io.Serializable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("habilitacoes")
public class HabilitacaoREST {
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHabilitacoes(@PathParam("id") Integer id) {
		return Response.ok(new Serializable() {
			private static final long serialVersionUID = 1L;
			
			public String getNome() {
				return "Felipe Diogo de Souza Pereira";
			}
			
			public Integer getPontos() {
				return 7;
			}
			
			public String getRenach() {
				return "7617172234";
			}
			
		}).build();
	}
	
}