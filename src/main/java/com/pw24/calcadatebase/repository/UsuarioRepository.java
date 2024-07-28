package com.pw24.calcadatebase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pw24.calcadatebase.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

    
}
