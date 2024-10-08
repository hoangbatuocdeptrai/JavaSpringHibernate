
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">Hello</h1>
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
							<table class="table table-dark" border="1">
								<tr>
									<td>Id</td>
									<td>${p.id}</td>
								</tr>
								<tr>
									<td>Name</td>
									<td>${p.name }</td>
								</tr>
								<tr>
									<td>Status</td>
									<td>${p.status ? "Còn":"Hết" }</td>
								</tr>
								<tr>
									<td><a href="${pageContext.request.contextPath}/admin/category/" class="btn btn-sm btn-primary">Back</a></td>
								</tr>

							</table>






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
