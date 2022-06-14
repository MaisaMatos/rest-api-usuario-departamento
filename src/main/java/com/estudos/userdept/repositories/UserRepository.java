package com.estudos.userdept.repositories;

import com.estudos.userdept.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

//deve ser interface porque o JPA Repository é uma interface
//é preciso informar o tipo do Objeto e do ID, é solicitado pela interface JPA
public interface UserRepository extends JpaRepository<User, Long>{

    //boolean existByEmail(String email);

    //este tipo terá todas as operações básicas de pesquisa, salver, apagar e atualizar o usuário

}
