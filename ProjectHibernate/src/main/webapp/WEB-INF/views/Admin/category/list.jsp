
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
							<form action="search" method="get" class="form-inline">
								<div class="form-group">
									<label class="sr-only" for="">label</label> <input
										class="form-control" name="name"
										placeholder="Nhập tên cần tìm">
								</div>
								<button type="submit" class="btn btn-default mr-1">
									<i class="fas fa-search"></i>
								</button>
								<a href="initInsert" class="btn btn-primary"><i
									class="fas fa-plus"></i> Add</a>
							</form>
							<br>
							<table class="table table-dark" border="1">
								<tr>
									<th>Id</th>
									<th>Name</th>
									<th>Status</th>
								</tr>
								<c:forEach items="${ca}" var="b">
									<tr>
										<td>${b.id}</td>
										<td>${b.name}</td>
										<td>${b.status}</td>
										<td>
											<a href="details?id=${b.id }" class="btn btn-sm btn-primary">Details</a>
											<a href="initUpdate?id=${b.id}" class="btn btn-sm btn-success">Edit</a>
											<a href="deleteCa?id=${b.id}" class="btn btn-sm btn-danger">Del</a>
										</td>
									</tr>
								</c:forEach>

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
