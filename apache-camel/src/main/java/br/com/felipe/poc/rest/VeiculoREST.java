package br.com.felipe.poc.rest;

import java.io.Serializable;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
public class VeiculoREST extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		restConfiguration().host("localhost").port(3030);

		rest()
			.get("condutor")
			.route()
				.to("rest:get:habilitacoes/1?bridgeEndpoint=true")
					.unmarshal().json(JsonLibrary.Jackson, Habilitacao.class)
					.setProperty("habilitacao", simple("${in.body}"))
					.marshal().json(JsonLibrary.Jackson)
				.to("rest:get:veiculos/1?bridgeEndpoint=true")
					.unmarshal().json(JsonLibrary.Jackson, Veiculo.class)
					.setProperty("veiculo", simple("${in.body}"))
					.marshal().json(JsonLibrary.Jackson)
				.log("Habilitação: ${property.habilitacao}")
				.log("Veículo: ${property.veiculo}")
				.toD("class:br.com.felipe.poc.rest.ConstroiBean?method=constroi&bean.habilitacao=${property.habilitacao}&bean.veiculo=${property:veiculo}");
				

	}
}

@Component("constroiBean")
class ConstroiBean {
	
	private Habilitacao habilitacao;
	private Veiculo veiculo;
	
	
	public Condutor constroi() {
		
		System.out.println("============>>>> CHAMOU!!!");
		
		Condutor condutor = new Condutor();
		condutor.setCor("amarelo");
		condutor.setModelo("corsa");
		condutor.setNome("felipe");
		condutor.setRenach("1231231231");
		
		return condutor;
	}
	
	public void setHabilitacao(Habilitacao habilitacao) {
		this.habilitacao = habilitacao;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
}

class Condutor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String renach;
	private String modelo;
	private String cor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRenach() {
		return renach;
	}

	public void setRenach(String renach) {
		this.renach = renach;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
}


@JsonIgnoreProperties({ "pontos" })
class Habilitacao implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;

	private String renach;

	private Integer pontos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRenach() {
		return renach;
	}

	public void setRenach(String renach) {
		this.renach = renach;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

}

@JsonIgnoreProperties({ "placa", "renavam" })
class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String modelo;

	private String cor;

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}