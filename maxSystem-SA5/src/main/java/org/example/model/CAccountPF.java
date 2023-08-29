package org.example.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "conta")
public class CAccountPF{

    @Id
    @Column(name = "numero_conta")
    private Long accountNumber;
    private Double saldo;
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "type")
    private AccountType accountType;

    @Transient
    //@Column
    private Date dataAtualizacao;

    @Transient
    private String error;

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public static String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Person getClient() {
        return person;
    }

    public void setClient(Person person) {
        this.person = person;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public static void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return saldo;
    }

    public void setBalance(Double saldo) {
        this.saldo = saldo;
    }

}
