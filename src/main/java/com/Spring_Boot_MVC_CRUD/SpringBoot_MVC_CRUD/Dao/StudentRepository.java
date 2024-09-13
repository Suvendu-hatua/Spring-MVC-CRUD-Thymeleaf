package com.Spring_Boot_MVC_CRUD.SpringBoot_MVC_CRUD.Dao;

import com.Spring_Boot_MVC_CRUD.SpringBoot_MVC_CRUD.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    //No implementation is required!!!
}
