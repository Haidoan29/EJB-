/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example.web;

import com.example.sessionbean.Student;
import com.example.sessionbean.StudentSessionBeanLocal;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet {

    @EJB
    private StudentSessionBeanLocal studentSessionBean;

    // Chỉ giữ lại danh sách sinh viên
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listStudents(req, resp);
    }

    // Chỉ giữ lại chức năng thêm sinh viên
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        createStudent(req, resp);
    }

    // Hiển thị danh sách sinh viên
    private void listStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = studentSessionBean.getAllStudents();
        req.setAttribute("students", students);
        req.getRequestDispatcher("/students.jsp").forward(req, resp);
    }

    // Tạo sinh viên mới
    private void createStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");

        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setEmail(email);
        studentSessionBean.addStudent(student);  // Thêm sinh viên vào cơ sở dữ liệu

        // Quay lại danh sách sinh viên sau khi thêm
        resp.sendRedirect("StudentServlet");
    }
}
