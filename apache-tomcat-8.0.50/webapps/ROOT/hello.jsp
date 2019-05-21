<%@ page contentType="text/html; charset=EUC-KR" %>
<h1>Hello JSP~~</h1>
<h2>안녕 제이에스피~~</h2>
<img src="tomcat.png" />
<%
   String today = new java.util.Date().toString();

   out.println("<b>"+today+"</b>");
%>