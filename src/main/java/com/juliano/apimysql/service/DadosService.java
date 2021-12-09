package com.juliano.apimysql.service;

import com.juliano.apimysql.model.Persons;
import com.juliano.apimysql.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DadosService implements PersonInterface{

    @Autowired
    private PersonRepository personRepository;

    public Optional<Persons> findById(long id){
        return personRepository.findById(id);
    }
}
