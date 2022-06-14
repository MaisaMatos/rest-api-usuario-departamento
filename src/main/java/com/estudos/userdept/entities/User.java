package com.estudos.userdept.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tb_user")
public class User {

    @Id //com isso, este Id será a chave primária do BD
    @GeneratedValue(strategy = GenerationType.IDENTITY) //com isso, o Id será auto-incrementado pelo banco
    private Long id;
    private String name;
    private String email;

    //este é um quarto atributo, que é a classe Department.
    //assim se faz a composição de objetos, a associação de entidades
    @ManyToOne //fazer a relação entre muitos Users para 1 Dept
    @JoinColumn(name = "department_id") //configuração o nome da chave estrangeira
    private Department department;

    public User() {
    }



}
