package com.gustavoj.cadastroveiculos.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.gustavoj.cadastroveiculos.domain.Veiculo;


public class VeiculoDTO {
	
	private Integer id;
	@NotEmpty(message = "Preenchimento obrigatório")
	@NotNull(message = "Não pode ser nullo")
	private String veiculo;
	@NotEmpty(message = "Preenchimento obrigatório")
	@NotNull(message = "Não pode ser nullo")
	private String marca;
	@NotNull(message = "Não pode ser nullo")
	private Integer ano;
	@NotEmpty(message = "Preenchimento obrigatório")
	@NotNull(message = "Não pode ser nullo")
	private String descricao;
	@NotNull(message = "Não pode ser nullo")
	private Boolean vendido;
	
	public VeiculoDTO() {
	}
	public VeiculoDTO(Veiculo obj) {
		this.id = obj.getId();
		this.veiculo = obj.getVeiculo();
		this.marca = obj.getMarca();
		this.ano = obj.getAno();
		this.descricao = obj.getDescricao();
		this.vendido = obj.getVendido();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Boolean getVendido() {
		return vendido;
	}
	public void setVendido(Boolean vendido) {
		this.vendido = vendido;
	}
	
	

}
