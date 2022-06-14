package com.estudos.userdept.repositories;

import com.estudos.userdept.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;



public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
