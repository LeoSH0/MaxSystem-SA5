package org.example.view;

import org.example.controller.Controller;
import org.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class PersonView {

    @Autowired
    Controller controller;
    @GetMapping("/person")
    public Person findClient(@PathParam("name") String name){
        return controller.findClient(name);
    }


    @DeleteMapping("/person")
    public String deleteClient(@PathParam("name") String name){
        controller.removeClient(name);

        return "O cliente: " + name + " foi deletado com sucesso!";
    }

    @PostMapping("/person")
    public Person addClient(@PathParam("name") String name, @PathParam("sexo") String sexo){
        return controller.addClient(name, sexo);
    }

    @PutMapping("/person")
    public Person updateClient(@PathParam("name") String name, @PathParam("sexo") String sexo){
        return controller.editClient(name, sexo);
    }

    @GetMapping("/all")
    public List<Person> listAll(){
        return controller.listAll();
    }
}
