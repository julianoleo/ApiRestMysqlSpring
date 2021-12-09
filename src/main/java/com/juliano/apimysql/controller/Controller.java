package com.juliano.apimysql.controller;

import com.juliano.apimysql.logs.LogType;
import com.juliano.apimysql.logs.Logs;
import com.juliano.apimysql.model.PersonsDTO;
import com.juliano.apimysql.model.PersonsDadosDTO;
import com.juliano.apimysql.service.DadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping({"api/v1"})
public class Controller {

    @Autowired
    private Logs logs;

    @Autowired
    private DadosService service;

    @GetMapping("/persons/{id}")
    public ResponseEntity<PersonsDTO> getPersonsById(
            @PathVariable("id") long id,
            HttpServletRequest request,
            @RequestHeader HttpHeaders headers
    ) {
        try {
            var persons = service.findById(id);
            if(persons.isEmpty()){
                throw new Exception(new Error("Pessoa não encontrada"));
            } else {
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

                var result = new ResponseEntity<PersonsDTO>(_listPesonsDTO, HttpStatus.OK);
                logs.logRequest(request, headers, result, LogType.INFO, null);
                return result;
            }
        } catch (Exception e){
            var _responseEntity =  new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
            logs.logRequest(request, headers, _responseEntity, LogType.WARN, "");
            return _responseEntity;
        }
    }
}
