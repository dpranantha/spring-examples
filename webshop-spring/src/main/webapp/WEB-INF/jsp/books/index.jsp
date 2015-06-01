<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
   <head>
   		<title>Books</title>
   		<script src="<c:url value="/resources/js/jquery-latest.js" />"></script>
   		<script src="<c:url value="/resources/js/jquery.tablesorter.js" />"></script>
   </head>
   <body>
      <table class="tablesorter">
         <tr>
            <th>Id</th>
            <th>Title</th>
         </tr>

         <c:forEach items="${books}"var="book">
           <tr>
           	  <td>${book.id}</td>
              <td>${book.title}</td>
           </tr>
         </c:forEach>
      </table>
   </body>
</html>