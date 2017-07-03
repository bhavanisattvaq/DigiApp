<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Digi Files</title>
</head>
<body>
<%if(session.getAttribute("useremail")==null)
 {
	 response.sendRedirect("index.jsp");
 }
 else
 {
 %>
    <div align="center">
        <h1>List Of Files</h1>
        <table border="1">
            <th>id</th>
            <th>Title</th>
            <th>Url_Front</th>
            <th>Url_Back</th>
            <th>Search</th>
            <th>Email</th>
            <th>Upload_date</th>
 <th>Action</th>
            <c:forEach var="employee" items="${listEmployee}">
                <tr>
 
                    <td>${employee.id}</td>
                    <td>${employee.title}</td>
                    <td><img src="upload/${employee.fpage}" width=50px height=50px/></td>
                    <td><img src="upload/${employee.bpage}"  width=50px height=50px/></td>
                    <td>${employee.search}</td>
                    <td>${employee.userEmail}</td>
                    <td>${employee.uploaddate}</td>
                    <td><a href="edit.htm?id=${employee.id}">Edit</a></td>
                            <%--  <a
                        href="deleteEmployee?id=${employee.id}">Delete</a></td> --%>
 
                </tr>
            </c:forEach>
        </table>
    </div>
    <%} %>
</body>
</html>
