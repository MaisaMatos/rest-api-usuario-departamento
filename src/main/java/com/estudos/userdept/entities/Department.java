package com.estudos.userdept.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity //a anotação Entity informa que esta classe será mapeada por uma tabela do BD
@Table(name = "tb_department") //informa que a classe virará uma tabela no BD, bem como seu nome
public class Department {

    @Id //com isso, este Id será a chave primária do BD
    @GeneratedValue(strategy = GenerationType.IDENTITY) //com isso, o Id será auto-incrementado pelo banco
    private Long id;
    private String name;

    public Department() {

    }


}
