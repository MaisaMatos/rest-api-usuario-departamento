package com.estudos.userdept.controllers;

import com.estudos.userdept.entities.Department;
import com.estudos.userdept.repositories.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/department")
@AllArgsConstructor
public class DepartmentController {

    //@Autowired
    private DepartmentRepository repository;

    @GetMapping
    public List<Department> findAll(){
        List<Department> result = repository.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Department> findById(@PathVariable Long id){
        Optional<Department> department = repository.findById(id);

        if(department.isPresent()){
            return ResponseEntity.ok(department.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Department insert(@RequestBody Department department){
        Department result = repository.save(department);
        return result;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Optional<Department> department = repository.findById(id);

        if(!department.isPresent()){
            return ResponseEntity.notFound().build();
        }
        repository.delete(department.get());

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Department> update(@Valid @RequestBody Department department, @PathVariable Long id){

        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        Department departmentBD = repository.getById(id);
        departmentBD.setName(departmentBD.getName());

        repository.save(departmentBD);

        return ResponseEntity.ok(departmentBD);
    }



}
