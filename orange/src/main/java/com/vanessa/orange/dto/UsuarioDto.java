package com.vanessa.orange.dto;

import java.util.List;

import com.vanessa.orange.model.Endereco;
import com.vanessa.orange.model.Usuario;

public class UsuarioDto {
	
	private String nome;
	
	private String email;
	
	private List<Endereco> enderecos;

	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}	
	
	public UsuarioDto(Usuario usuario) {
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.enderecos = usuario.getEnderecos();
	}

}
