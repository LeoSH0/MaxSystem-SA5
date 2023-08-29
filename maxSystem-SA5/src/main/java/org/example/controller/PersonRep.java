package org.example.controller;

import org.example.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRep extends CrudRepository<Person, Integer >{
}
