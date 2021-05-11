package com.vanessa.orange.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vanessa.orange.model.Endereco;



@FeignClient(url="https://viacep.com.br/ws/", name= "viacep")
public interface ApiService {
	
	@GetMapping("{cep}/json")
	Endereco getEndereco(@PathVariable("cep")String cep);	
	
}
