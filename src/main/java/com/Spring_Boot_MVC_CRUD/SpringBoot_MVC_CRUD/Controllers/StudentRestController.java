package com.Spring_Boot_MVC_CRUD.SpringBoot_MVC_CRUD.Controllers;

import com.Spring_Boot_MVC_CRUD.SpringBoot_MVC_CRUD.Entities.Student;
import com.Spring_Boot_MVC_CRUD.SpringBoot_MVC_CRUD.Services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentRestController {
    private StudentService studentService;

    //Reading countries from application.properties file
    @Value("${countries}")
    List<String> countryList;

    public StudentRestController(StudentService studentService){
        this.studentService=studentService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    //Create/Insert
    @PostMapping("/save")
    public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult,Model theModel){
        System.out.println(student);
        Student stu=null;
        if(bindingResult.hasErrors()){
//            theModel.addAttribute("student",student);
            System.out.println(bindingResult.toString());
            //Adding countryList to the Model if error occurs.
            theModel.addAttribute("countries",countryList);
            return "Student/show-registration";
        }
        try{
            stu=studentService.saveStudent(student);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "redirect:student-list";
    }
    @PostMapping("/save-update")
    public String saveUpdateStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult){
        System.out.println(student);
        Student stu=null;
        if(bindingResult.hasErrors()){
//            theModel.addAttribute("student",student);
            System.out.println(bindingResult.toString());
            return "Student/update-details";
        }
        try{
            stu=studentService.saveStudent(student);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "redirect:student-list";
    }

    //Retrieve
    @GetMapping("/student-list")
    public String retrieveStudents(Model theModel){
        List<Student> studentList=null;
        try{
            studentList=studentService.findAllStudents();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        //adding StudentList to the Model
        theModel.addAttribute("studentList",studentList);
        return "Student/student-list";
    }

    @GetMapping("/show-registration")
    public String showRegistrationForm(Model theModel){
        //Creating an instance of Student Object
        Student student=new Student();
        //Adding instance to Model
        theModel.addAttribute("student",student);
        theModel.addAttribute("countries",countryList);
        return "Student/show-registration";
    }

    //********************End Point for displaying each individual Student Profile.
    @GetMapping("/view")
    public String viewIndividualStudent(@RequestParam("studentId")Integer studentId,Model theModel){
        Student student=studentService.findById(studentId);
        //Adding student instance to the Model.
        theModel.addAttribute("student",student);
        return "Student/view-individual-student";
    }
    //Update/Modify
    @GetMapping("/update")
    public String updateStudentDetails(@RequestParam("studentId") Integer studentId,Model theModel){
        Student student=studentService.findById(studentId);
        //Adding student instance to the Model.
        theModel.addAttribute("student",student);
        return "Student/update-details";
    }


    //Delete
    @GetMapping("/delete/{studentId}")
    public String  deleteStudent(@PathVariable Integer studentId){
        try{
            System.out.println("Student to be deleted-->"+studentId);
            studentService.deleteStudent(studentId);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "redirect:/students/student-list";
    }

}
