<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Bất kỳ xử lý phía máy chủ nào cần thiết
    response.sendRedirect("customer/index");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Đang chuyển hướng...</title>
</head>
<body>
    <p>Nếu bạn không được tự động chuyển hướng, hãy theo liên kết này <a href="customer/index">link</a>.</p>
</body>
</html>