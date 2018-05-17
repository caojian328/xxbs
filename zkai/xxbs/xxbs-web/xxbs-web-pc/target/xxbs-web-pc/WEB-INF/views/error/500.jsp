<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head><title>系统异常</title></head>
<body>
<% Exception e = (Exception)request.getAttribute("ex"); %>
<H2><%=e.getClass().getName()%></H2>
<hr />
<%--  
<P>错误描述：</P>
<%= e.getMessage()%>
--%>
<P>错误信息：</P>
<pre>
<% e.printStackTrace(new java.io.PrintWriter(out)); %>
</pre>
</body>
</html>