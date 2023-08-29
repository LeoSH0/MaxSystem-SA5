package org.example.controller;

import org.example.model.Account;
import org.example.model.CAccountPF;


import javax.websocket.server.PathParam;

public interface CAccount {

    Double withdraw(Double quantidade, Account conta);

    void deposit(Double quantidade, Account conta);

    String transfer(Long contaOrigem, Long contaDestino, Double valor);

    Double checkBalance(CAccountPF conta);

}
