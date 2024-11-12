/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.example.sessionbean;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Stateless session bean for managing Student entities.
 */
@Stateless
public class StudentSessionBean implements StudentSessionBeanLocal {
    
    @PersistenceContext(unitName = "project01-ejbPU")
    private EntityManager em;

    @Override
    public List<Student> getAllStudents() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    public void addStudent(Student student) {
        em.persist(student);
    }
}
