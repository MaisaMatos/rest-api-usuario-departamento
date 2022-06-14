package com.estudos.userdept.controllers;

import com.estudos.userdept.entities.User;
import com.estudos.userdept.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserController {

    private UserRepository repository;

    @GetMapping
    public List<User> findAll(){
        List<User> result =  repository.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        Optional<User> user = repository.findById(id);

        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }

    /*
    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> insert(@RequestBody User user){

        if(repository.existByEmail(user.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        User userResult =  repository.save(user);
        return ResponseEntity.created(URI.create("/users" + userResult)).build() ;
    }
    */



    /*
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User insert(@RequestBody User user){
        User result =  repository.save(user);
        return result;
    }

     */



    /*vou buscar no BD o usuário a apagar através do id
       e o retorno dessa busca será um objeto User.
       Ao trazer o usuário, chamo o método delete, que não tem retorno,
       mas para o usuário aparecerá a resposta "No_Content".
     */

    @DeleteMapping(value = "/{id}")
    public ResponseEntity <Void> delete(@PathVariable Long id){
        Optional<User> user = repository.findById(id);

        if(!user.isPresent()){
            return ResponseEntity.notFound().build();
        }
        repository.delete(user.get());

        return ResponseEntity.noContent().build();
    }

    /*
    Após fazer as alteração no BD
     */


    @PutMapping(value = "/{id}")
        public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id){

            Optional<User> userOptional = repository.findById(id);

            if(!userOptional.isPresent()){
                return ResponseEntity.notFound().build();
            }

            userOptional.get().setName(user.getName());
            userOptional.get().setDepartment(user.getDepartment());
            userOptional.get().setEmail(user.getEmail());

            repository.save(userOptional.get());

            return ResponseEntity.ok(userOptional.get());

    }





}
