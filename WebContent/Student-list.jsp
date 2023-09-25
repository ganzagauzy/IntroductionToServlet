<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
 <title>Student Management Application</title>
</head>
<body>
<div class="container">
  <h1>My Beautiful JSP Page</h1>

  <div class="alert alert-success" role="alert">
    This is a Bootstrap alert!
  </div>

  <div class="row">
    <div class="col-md-6">
      <p>This is a Bootstrap grid column.</p>
    </div>
    <div class="col-md-6">
      <p>This is another Bootstrap grid column.</p>
    </div>
  </div>
 <center>
  <h1>Student Management</h1>
        <h2>
         <a href="new">Add New Student</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">List All Students</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Students</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="Student" items="${listStudent}">
                <tr>
                    <td><c:out value="${Student.id}" /></td>
                    <td><c:out value="${Student.name}" /></td>
                    <td><c:out value="${Student.email}" /></td>
                    <td><c:out value="${Student.country}" /></td>
                    <td>
                     <a href="edit?id=<c:out value='${Student.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${Student.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/main.js"></script>
</body>
</html>