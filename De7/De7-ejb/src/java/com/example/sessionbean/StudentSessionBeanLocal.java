/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.example.sessionbean;

import java.util.List;
import javax.ejb.Local;

@Local
public interface StudentSessionBeanLocal {
    List<Student> getAllStudents();
    void addStudent(Student student);
}
