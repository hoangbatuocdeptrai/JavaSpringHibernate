<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	category
	<a href="${pageContext.request.contextPath}/admin/category/"
		class="nav-link"> <i class="far fa-circle nav-icon"></i>
		<p>List</p>
	</a>
	<a href="${pageContext.request.contextPath}/admin/category/initInsert"
		class="nav-link"> <i class="far fa-circle nav-icon"></i>
		<p>Add</p>
	</a> product
	<a href="${pageContext.request.contextPath}/admin/product/"
		class="nav-link"> <i class="far fa-circle nav-icon"></i>
		<p>List</p>
	</a>
	<a href="${pageContext.request.contextPath}/admin/product/initInsert"
		class="nav-link"> <i class="far fa-circle nav-icon"></i>
			<p>Add</p></a>
	
</body>
</html>