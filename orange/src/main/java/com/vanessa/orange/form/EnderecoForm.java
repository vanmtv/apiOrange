package com.vanessa.orange.form;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vanessa.orange.model.Endereco;
import com.vanessa.orange.repositorio.EnderecoRepository;

public class EnderecoForm {
	
	@JsonProperty("cep")
	@NotNull
	private String cep;
	
	@NotNull
	private Integer numero;
	
	private String complemento;

	public String getCep() {
		return cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void cadastrar(Endereco endereco, EnderecoForm form, EnderecoRepository repository) {
		if(form.getComplemento() != null) {
			endereco.setComplemento(complemento);
		}
		endereco.setNumero(numero);
		repository.save(endereco);		
	}

	
	
}
