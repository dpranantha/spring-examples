<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="webshop.controllers.*"%>
<%@page import="webshop.dao.*"%>
<%@page import="webshop.domain.*"%>
<jsp:useBean id="bookDao" type="webshop.dao.TheBookDao" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
    <head>
        <title>Online Library</title>
    </head>
 
    <body>
        <hr><ol> 
        <% for (Book book : bookDao.listBooks()) { %>
            <li> <%= book %> </li>
        <% } %>
        </ol><hr>
 
        <iframe src="http://www.objectdb.com/pw.html?spring-eclipse"
            frameborder="0" scrolling="no" width="100%" height="30"> </iframe>
     </body>
 </html>