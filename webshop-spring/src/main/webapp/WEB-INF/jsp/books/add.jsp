<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
   <head>
   		<title>Books</title>
   </head>
   <body>
   <form:form method="POST" action="add" modelAttribute="book">
	  <form:errors path="title"/>
   	  <table>
         <tr>
         	<td>Title: </td>
         	<td><form:input path="title"/></td>
         </tr>
         <tr>
         	<td></td>
         	<td><input type="submit" id="submit"/></td>
         </tr>
      </table>
   </form:form>
   </body>
</html>