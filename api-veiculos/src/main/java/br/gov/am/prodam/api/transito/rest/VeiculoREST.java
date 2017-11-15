package br.gov.am.prodam.api.transito.rest;

import java.io.Serializable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("veiculos")
public class VeiculoREST {
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVeiculos(@PathParam("id") Integer id) {
		return Response.ok(new Serializable() {
			private static final long serialVersionUID = 1L;
			
			public String getPlaca() {
				return "JWT-6965";
			}
			
			public String getRenavam() {
				return "2341JG123545343J";
			}
			
			public String getModelo() {
				return "Fusca";
			}
			
			public String getCor() {
				return "Amarelo";
			}
			
		}).build();
	}
	
}
