package com.pw24.calcadatebase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pw24.calcadatebase.domain.Usuario;
import com.pw24.calcadatebase.repository.UsuarioRepository;

@Service
public class UsuarioService { 
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }
    //Retornando uma Usuario de acordo com o id passado
    public Optional<Usuario> findById(String id){
        return repository.findById(id);

    }
    //Deletando uma Usuario de acordo com o ID passado
    public void delete(String id){
        repository.deleteById(id);
    }
    //Atualizando uma Usuario
    public Usuario update(Usuario usuario){
        return repository.saveAndFlush(usuario);
     }
     //Criando uma Usuario e aplicando regra de negocio para nome da nome de Usuario
     public Usuario create(Usuario usuario){
        usuario.upperCaseUsuarioName();
        return repository.save(usuario);
    }
    //Lista todas as Usuario cadastradas no banco de dados.
    public List<Usuario> findAll(){
        return repository.findAll();
    }

    
}
