package org.example.controller;

import org.example.model.CAccountPF;
import org.springframework.data.repository.CrudRepository;

public interface BancoRep extends CrudRepository<CAccountPF, Long>{

}
