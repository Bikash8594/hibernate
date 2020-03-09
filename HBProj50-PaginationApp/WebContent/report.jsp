<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<c:choose>
   <c:when  test="${!empty  listDTO }">
       <table bgColor="cyan" align="center"  border="1">
         <tr bordercolor="red"><th>eid</th><th>name </th> <th>address </th> <th> salary</th><th>desg </th> </tr>
       
       <c:forEach var="dto" items="${listDTO }">
            <tr bordercolor="yellow">
               <td>${dto.eid } </td>
               <td>${dto.ename } </td>
               <td>${dto.eadd } </td>
               <td>${dto.esalary } </td>
               <td>${dto.edesg } </td>
            </tr>
       </c:forEach>
       </table>
       <br>
       <c:forEach var="i"  begin="1" end="${pagesCount}"  step="1">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;         [<a href="controller?pageNo=${i}">${i}</a>] &nbsp;&nbsp;&nbsp;&nbsp;  
       </c:forEach>
   </c:when>
    <c:otherwise>
            <h1 style="color:red;text-align:center">Records not found </h1>
    </c:otherwise>
</c:choose>    
<br> <br><br>
  <a href="form.html">home</a>
