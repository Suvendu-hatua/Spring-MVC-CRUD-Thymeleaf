package com.Spring_Boot_MVC_CRUD.SpringBoot_MVC_CRUD.Services;

import com.Spring_Boot_MVC_CRUD.SpringBoot_MVC_CRUD.Dao.StudentRepository;
import com.Spring_Boot_MVC_CRUD.SpringBoot_MVC_CRUD.Entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService{
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImp(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }


    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Integer Id) {
        Optional<Student> result =studentRepository.findById(Id);
        Student student=null;
        if(result.isPresent()){
            student=result.get();
        }
        return student;
    }

    @Override
    public Student saveStudent(Student student) {
       return studentRepository.save(student);

    }

    @Override
    public void deleteStudent(Integer Id) {
        studentRepository.deleteById(Id);
    }
}
