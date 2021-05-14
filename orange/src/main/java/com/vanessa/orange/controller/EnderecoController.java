package com.vanessa.orange.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vanessa.orange.dto.UsuarioDto;
import com.vanessa.orange.form.EnderecoForm;
import com.vanessa.orange.model.Endereco;
import com.vanessa.orange.model.Usuario;
import com.vanessa.orange.repositorio.EnderecoRepository;
import com.vanessa.orange.repositorio.UsuarioRepository;
import com.vanessa.orange.service.ApiService;

@RestController
@RequestMapping("/endereco")
@EnableFeignClients(basePackages = {"com.vanessa.orange.service","com.vanessa.orange.controller"})
public class EnderecoController {
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	private ApiService viacep;
	
	@PostMapping("/cadastrar/{id}")
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid EnderecoForm form, @PathVariable Long id){
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if(usuario.isPresent()) {
			Endereco endereco = viacep.getEndereco(form.getCep());
			endereco.setUsuario(usuario.get());
			form.cadastrar(endereco,form, enderecoRepository);
			return ResponseEntity.status(HttpStatus.CREATED).body(new UsuarioDto(usuario.get()));
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
}
