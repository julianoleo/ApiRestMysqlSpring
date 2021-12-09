package com.juliano.apimysql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonsDTO {
    private Set<Optional<PersonsDadosDTO>> pessoas;
}
