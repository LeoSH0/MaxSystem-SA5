package org.example.view;

import org.example.controller.BController;
import org.example.model.AccountType;
import org.example.model.CAccountPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;

@RestController
public class BancoView {
    @Autowired
    private BController bController;

    @PostMapping("/criaconta")
    public CAccountPF createAcc(@PathParam("name") String name, @PathParam("type") String type) throws Exception {
        return bController.createAcc(name, type);

    }
    @DeleteMapping("/banco")
    public void delete(@PathParam("name") String name){
        bController.delete(name);

    }
    @GetMapping("/type")
    public String listAccountType() {
        String text = AccountType.CONTA_CORRENTE + ", " + AccountType.CONTA_POUPANCA;
        return text;

    }
    @GetMapping("/consultaconta")
    public CAccountPF ccheckAcc(@PathParam("name") String name) {
        return bController.checkAcc(name);

    }
    @PutMapping("/transferir")
    public String transfer(@PathParam("contaOrigem") Long contaOrigem, @PathParam("contaDestino") Long contaDestino, @PathParam("valor") Double valor){
        return bController.transfer(contaOrigem, contaDestino, valor);

    }

}

