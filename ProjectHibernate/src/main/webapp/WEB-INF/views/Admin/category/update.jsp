
<%@ include file="../Banner/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style type="text/css">
	.colorRed {
		color: red;
}
</style>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">Add Category</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Dashboard v3</li>
					</ol>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /.content-header -->

	<!-- Main content -->
	<div class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<div class="card">
						<div class="card-header border-0">
						<h3 style="color:red">${err}</h3>
							<form:form action="updateCategory" method="post" modelAttribute="c">
								<div class="row">
									<div class="col-md-5">
									<form:input path="Id" type="hidden"/>
										<div class="form-group">
											<label class="control-label">Tên</label> 
											<form:input path="name" class="form-control"/>
											<form:errors cssClass="colorRed" path="name"></form:errors>
										</div>
										<div class="form-group">
											<label class="control-label">Trạng thái</label> 
											<form:radiobutton path="Status" value="true"/>Hiện
											<form:radiobutton path="Status" value="false"/>Ẩn
										</div>
										<div class="form-group">
											<input type="submit" class="btn btn-primary" />
											<a href="${pageContext.request.contextPath}/admin/category/" class="btn btn-danger">Back to List</a>
										</div>
									</div>
								</div>
							</form:form>
						</div>
					</div>
					<div class="card-body table-responsive p-0"></div>

				</div>
				<!-- /.card -->
			</div>
		</div>
	</div>
</div>

<!-- /.content-wrapper -->

<!-- Control Sidebar -->
<aside class="control-sidebar control-sidebar-dark">
	<!-- Control sidebar content goes here -->
</aside>
<!-- /.control-sidebar -->
<%@ include file="../Banner/footer.jsp"%>
