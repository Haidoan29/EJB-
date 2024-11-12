<%@page import="java.util.List"%>
<%@page import="com.example.sessionbean.Student"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh Sách Sinh Viên</title>
    <style>
        table {
            width: 50%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
    </style>
</head>
<body>
    <h2>Danh Sách Sinh Viên</h2>
    <table>
        <thead>
            <tr>
                <th>Mã sinh viên</th>
                <th>Tên</th>
                <th>Tuổi</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
    <%
        // Lấy danh sách sinh viên từ request attribute
        List<Student> students = (List<Student>) request.getAttribute("students");
        
        // Kiểm tra nếu danh sách không rỗng
        if (students != null) {
            for (Student student : students) {
    %>
                <tr>
                    <td><%= student.getRollnumber() %></td>
                    <td><%= student.getName() %></td>
                    <td><%= student.getAge() %></td>
                    <td><%= student.getEmail() %></td>
                   
                </tr>
    <%
            }
        }
    %>
</tbody>

        </tbody>
    </table>
    <p>
        <form action="StudentServlet" method="get">
            <input type="hidden" name="action" value="add" />
            <input type="submit" value="Add Student" />
        </form>
    </p>
    <p>
        <form action="index.jsp" method="get">
            <input type="submit" value="Go to Index" />
        </form>
    </p>
</body>
</html>
