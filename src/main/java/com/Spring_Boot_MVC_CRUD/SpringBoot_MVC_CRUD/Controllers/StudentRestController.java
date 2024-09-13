package com.Spring_Boot_MVC_CRUD.SpringBoot_MVC_CRUD.Controllers;

import com.Spring_Boot_MVC_CRUD.SpringBoot_MVC_CRUD.Entities.Student;
import com.Spring_Boot_MVC_CRUD.SpringBoot_MVC_CRUD.Services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentRestController {
    private StudentService studentService;

    public StudentRestController(StudentService studentService){
        this.studentService=studentService;
    }
    //Create/Insert
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        System.out.println(student);
        Student stu=null;
        try{
            stu=studentService.saveStudent(student);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return stu;
    }
    //Retrieve
    @GetMapping("/students")
    public List<Student> retrieveStudents(){
        List<Student> studentList=null;
        try{
            studentList=studentService.findAllStudents();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return studentList;
    }

    @GetMapping("/students/{studentId}")
    public Student findById(@PathVariable Integer studentId){
        Student student=null;
        try{
            student=studentService.findById(studentId);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(student!=null){
            return student;
        }
        return student;
    }
    //Update/Modify
    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student){
        Student stu=null;
        try{
            stu=studentService.saveStudent(student);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return stu;
    }

    //Delete
    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable Integer studentId){
        try{
            studentService.deleteStudent(studentId);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
