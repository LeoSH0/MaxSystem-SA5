package org.example.controller;

import org.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Controller {

    @Autowired
    private PersonRep personRep;
    private List<Person> persons = new ArrayList<>();
    private int id = 0;

    public Person findClient(String name){
        List<Person> persons = (List<Person>) personRep.findAll();
        for(Person p : persons){
            if(persons.getName().equals(name)){
                return p;
            }
        }

        return null;
    }

    public Person addClient(String name, String sexo){
        Person p = new Person();
        p.setName(name);
        p.setSexo(sexo);
        id++;
        p.setId(id);
        personRep.save(p);
        return p;
    }

    public void removeClient(String name){
        Person p = findClient(name);
        personRep.delete(p);
    }

    public Person editClient(String name, String sexo){
        Person p = findClient(name);
        p.setSexo(sexo);
        personRep.save(p);
        return p;
    }

    public List<Person> listAll(){
        return (List<Person>)personRep.findAll();
    }

}
