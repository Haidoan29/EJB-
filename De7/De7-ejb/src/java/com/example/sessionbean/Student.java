/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sessionbean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Student")  // Updated table name to "Student"
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")  // Retained only the findAll query
})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 20) 
    private String rollnumber;  
    
    @Size(max = 100)
    @Column(length = 100)
    private String name;
    
    private Integer age;
    
    @Size(max = 100)
    @Column(length = 100)
    private String email;

    public Student() {
    }

    public Student(String rollnumber, String name, Integer age, String email) {
        this.rollnumber = rollnumber;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(String rollnumber) {
        this.rollnumber = rollnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rollnumber != null ? rollnumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        return (this.rollnumber != null || other.rollnumber == null) && (this.rollnumber == null || this.rollnumber.equals(other.rollnumber));
    }

    @Override
    public String toString() {
        return "com.example.ejb.Student[ rollnumber=" + rollnumber + " ]";
    }
}
