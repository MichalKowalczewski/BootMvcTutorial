<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
   <body>
      <form:form action = "go" method = "POST" modelAttribute="user">
         <form:errors path="*" element="div" />
         First Name: <form:input path="firstName"/></td>
         <form:errors path="firstName"/>
         <br/>
         Last Name: <form:input path="lastName"/></td>
         <form:errors path="lastName"/>
         <br/>
         <input type = "submit" value = "Submit" />
      </form:form>
   </body>
</html>