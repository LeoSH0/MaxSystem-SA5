package org.example.controller;

import org.example.model.AccountType;
import org.example.model.CAccountPF;
import org.example.model.Account;
import org.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BController implements CAccount {

    @Autowired
    private BancoRep bancoRep;

    @Autowired
    private Controller controller;

    private Long number = 0L;
    @Override
    public Double withdraw(Double quantidade, Account conta) {
        return null;
    }

    public void delete(String name){
        bancoRep.delete(this.checkAcc(name));
    }

    public CAccountPF createAcc(String name, String accountType) throws Exception {
        CAccountPF cAccountPF = new CAccountPF();
        StringBuilder message = new StringBuilder();
        if(accountType == null){
            message.append("\nNecessário informar o tipo da conta!");
        }
        switch (accountType){
            case "POUPANÇA" :
                cAccountPF.setAccountType(AccountType.CONTA_POUPANCA);
                break;
            case "CORRENTE" :
                cAccountPF.setAccountType(AccountType.CONTA_CORRENTE);
            default:
                message.append("\nEste tipo de conta não é suportado!");
        }
        Person person = controller.findClient(name);
        if(person != null && CAccountPF.getError() == null){
            number++;
            cAccountPF.setAccountNumber(number);
            cAccountPF.setClient(person);
            bancoRep.save(cAccountPF);
        }else if(CAccountPF.getError() == null){
            message.append("\nPessoa ");
            message.append(name).append(" informada não foi cadastrada");
        }
        if(!message.isEmpty()){
            cAccountPF.setError(message.toString());
        }

        return cAccountPF;
    }

    public CAccountPF checkAcc(String name){

        List<CAccountPF> contas = (List<CAccountPF>) bancoRep.findAll();

        for(CAccountPF cc : contas){
            if(cc.getClient() != null && cc.getClient().getName().equals(name)){

                return cc;


            }
        }
        return null;
    }


    @Override
    public void deposit(Double quantidade, Account conta) {
        Double total = conta.getBalance() + quantidade ;
        conta.setBalance(total);
    }

    @Override
    public String transfer(Long contaOrigem, Long contaDestino, Double valor) {
        String message = "";
        CAccountPF destino = bancoRep.findById(contaDestino).get();
        CAccountPF origem = bancoRep.findById(contaOrigem).get();

        if(origem.getBalance() >= valor){
            destino.setBalance(destino.getBalance() + valor);
            origem.setBalance(origem.getBalance() - valor);
            bancoRep.save(destino);
            bancoRep.save(origem);
            message = "A conta do(a) " + destino.getClient().getName() + " recebeu a transferência no valor de R$ " + valor;
        }else{
            message = message + " Seu saldo é insuficiente para esta operação";
        }

        return message;
    }

    @Override
    public Double checkBalance(CAccountPF conta) {
        return conta.getBalance();
    }
}

