package com.vanessa.orange.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vanessa.orange.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
