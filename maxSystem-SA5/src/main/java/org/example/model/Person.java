package org.example.model;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    private Integer id;

    private String name;

    private String sexo;
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private CAccountPF CAccountPF;

    public CAccountPF getCAccountPF() {
        return CAccountPF;
    }

    public void setCAccountPF(CAccountPF CAccountPF) {
        this.CAccountPF = CAccountPF;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
