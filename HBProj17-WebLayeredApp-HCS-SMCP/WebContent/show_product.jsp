<%@ page import="com.nt.dto.*" %>
    
    <h1  style="color:red;text-align:center"> Result jsp page </h1>
    <%
             //read request attribute values
         Object rows[]=(Object[])request.getAttribute("results");
          ProductDTO  pDTO=(ProductDTO)rows[0];
          ManifacturerDTO mDTO=(ManifacturerDTO)rows[1];
    %>
      <b>Product details are ::</b>
              <table>
                  <tr>
                      <td><%=pDTO.getPid()%> </td>
                      <td><%=pDTO.getPname() %> </td>
                      <td><%=pDTO.getPrice() %> </td>
                      <td><%=pDTO.getQty() %> </td>
                      <td> <%=pDTO.isStatus() %> </td>
                      <td> <%=pDTO.getMid()%> </td>
                  </tr>
               </table>
  <br><br>
  
       <b>Manifacturer details are ::</b>
              <table>
                  <tr>
                      <td><%=mDTO.getMid()%> </td>
                      <td><%=mDTO.getMname() %> </td>
                      <td><%=mDTO.getLocation() %> </td>
                      <td><%=mDTO.getGstNo() %> </td>
                  </tr>
               </table>
 <br><br>
   <a href="input.html">home</a>               
                 
