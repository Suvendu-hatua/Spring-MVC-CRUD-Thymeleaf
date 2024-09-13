package com.Spring_Boot_MVC_CRUD.SpringBoot_MVC_CRUD.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity()
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @NotBlank(message = "is required!")
    @Column(name = "first_name")
    @Size(min = 5,message = "first Name must be of minimum 5 characters.")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    @NotBlank(message = "is required!")
    @Email()
    private String email;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public @NotBlank(message = "is required!") @Size(min = 5, message = "first Name must be of minimum 5 characters.") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "is required!") @Size(min = 5, message = "first Name must be of minimum 5 characters.") String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public  String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Overriding toString() method

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
