package com.juliano.apimysql.service;

import com.juliano.apimysql.model.Persons;
import com.juliano.apimysql.model.PersonsDTO;
import com.juliano.apimysql.model.PersonsDadosDTO;
import com.juliano.apimysql.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class DadosService implements PersonInterface{

    @Autowired
    private PersonRepository personRepository;

    public Optional<Persons> findById(long id){
        return personRepository.findById(id);
    }

    public PersonsDTO criaPersonDTO(Optional<Persons> persons){
        PersonsDadosDTO personsDadosDTO = new PersonsDadosDTO();
        personsDadosDTO.setId(Optional.ofNullable(persons.orElseThrow().getId()));
        personsDadosDTO.setNome(Optional.ofNullable(persons.orElseThrow().getName()));
        personsDadosDTO.setDocumento(Optional.ofNullable(persons.orElseThrow().getDocument()));
        personsDadosDTO.setContatos(Optional.ofNullable(persons.get().getContatos()));

        Set<Optional<PersonsDadosDTO>> _persons = new HashSet<>();
        _persons.add(Optional.of(personsDadosDTO));
        _persons.iterator();

        PersonsDTO _listPesonsDTO = new PersonsDTO();
        _listPesonsDTO.setPessoas(_persons);

        return _listPesonsDTO;
    }
}
