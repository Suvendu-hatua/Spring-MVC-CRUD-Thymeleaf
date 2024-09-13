package com.Spring_Boot_MVC_CRUD.SpringBoot_MVC_CRUD.Services;

import com.Spring_Boot_MVC_CRUD.SpringBoot_MVC_CRUD.Entities.Student;

import java.util.List;

public interface StudentService {
    public List<Student> findAllStudents();
    public Student findById(Integer Id);
    public Student saveStudent(Student student);
    public void deleteStudent(Integer id);
}
