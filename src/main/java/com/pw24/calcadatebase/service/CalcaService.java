package com.pw24.calcadatebase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pw24.calcadatebase.domain.Calca;
import com.pw24.calcadatebase.repository.CalcaRepository;

@Service
public class CalcaService {

    private final CalcaRepository repository;
    //passando um repositorio de Calça no construtor de CalcaServise
    public CalcaService(CalcaRepository repository){
        this.repository = repository;
    }
    //Retornando uma calça de acordo com o id passado
    public Optional<Calca> findById(String id){
        return repository.findById(id);

    }
    //Deletando uma Calça de acordo com o ID passado
    public void delete(String id){
        repository.deleteById(id);
    }
    //Atualizando uma Calça
    public Calca update(Calca calca){
        return repository.saveAndFlush(calca);
     }
     //Criando uma calça e aplicando regra de negocio para nome da calça
     public Calca create(Calca calca){
        //calca.upperCaseCalcaName();
        return repository.save(calca);
    }
    //Lista todas as Calças cadastradas no banco de dados.
    public List<Calca> findAll(){
        return repository.findAll();
    }


    
}
