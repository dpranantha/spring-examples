<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
   <head>
   		<title>Books</title>
   		<link href="<c:url value="/resources/theme/css/style.css" />" rel="stylesheet">
		<script src="<c:url value="/resources/theme/js/jquery-latest.js" />"></script>
		<script src="<c:url value="/resources/theme/js/jquery.tablesorter.js" />"></script>
   </head>
   <body>
      <table id="myTable" class="tablesorter">
         <tr>
            <th>Id</th>
            <th>Title</th>
         </tr>
         <c:forEach items="${books}"var="book">
           <tr>
           	  <td>${book.id}</td>
              <td>${book.title}</td>
              <td><a href="books/edit?id=${book.id}">Edit</a></td>
           </tr>
         </c:forEach>
      </table>
		<script type="text/javascript">
   			$(document).ready(function() 
   			    { 
   			        $("#myTable").tablesorter(); 
   			    } 
   			); 
   			    
   		</script>
   </body>
</html>
