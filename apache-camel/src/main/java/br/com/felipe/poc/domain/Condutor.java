package br.com.felipe.poc.domain;

import java.io.Serializable;

public class Condutor implements Serializable {

	private static final long serialVersionUID = 1L;

	private DadosCondutor condutor;
	private DadosVeiculo veiculo;
	
	public Condutor(String nome, String renach, String modelo, String cor) {
		condutor = new DadosCondutor(nome, renach);
		veiculo = new DadosVeiculo(modelo, cor);
	}
	
	public DadosCondutor getDadosCondutor() {
		return condutor;
	}
	
	public DadosVeiculo getDadosVeiculo() {
		return veiculo;
	}

}

class DadosCondutor {
	private String nome;
	private String renach;
	
	public DadosCondutor(String nome2, String renach2) {
		this.nome = nome2;
		this.renach = renach2;
	}

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

}


class DadosVeiculo {
	private String modelo;
	private String cor;

	

	public DadosVeiculo(String modelo2, String cor2) {
		this.modelo = modelo2;
		this.cor = cor2;
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