package com.juliano.apimysql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonsDadosDTO {
    private Optional<Long> id;
    private Optional<String> nome;
    private Optional<String> documento;
    private Optional<List<Contact>> contatos;
}
