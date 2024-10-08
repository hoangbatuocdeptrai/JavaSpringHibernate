<%@ include file="../Banner/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html xmlns:th="http://www.thymeleaf.org">
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">List Category</h1>
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
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label class="sr-only" for="">Nhập</label> <input
												class="form-control" name="name"
												placeholder="Nhập tên cần tìm">
										</div>
										<button type="submit" class="btn btn-default mr-1">
											<i class="fas fa-search"></i>
										</button>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label></label>
										</div>
										<a href="initInsert" class="btn btn-primary"><i
											class="fas fa-plus"></i> Add</a>
									</div>
								</div>


							</form>
							<br>
							<h3 style="color: red">${err}</h3>
							<table class="table" border="1">
								<tr>
									<th>Id</th>
									<th>Name</th>
									<th>Status</th>
									<th></th>
								</tr>
								<c:forEach items="${ca}" var="b">
									<tr>
										<td>${b.id}</td>
										<td>${b.name}</td>
										<td>${b.status}</td>
										<td><a href="details?id=${b.id }"
											class="btn btn-sm btn-primary">Details</a> <a
											href="initUpdate?id=${b.id}" class="btn btn-sm btn-success">Edit</a>
											<a href="deleteCa?id=${b.id}" class="btn btn-sm btn-danger">Del</a>
										</td>
									</tr>
								</c:forEach>

							</table>
							<div class="text-center">
								<c:if test="${currentPage gt 1}">
									<a class="btn btn-sm btn-primary"
										href="?name=${param.name}&page=1&size=${size}">First</a>
									<a class="btn btn-sm btn-primary"
										href="?name=${param.name}&page=${currentPage - 1}&size=${size}">Previous</a>
								</c:if>

								<c:forEach begin="1" end="${totalPages}" var="pageNum">
									<c:if test="${pageNum eq currentPage}">
							            ${pageNum}
							        </c:if>
									<c:if test="${pageNum ne currentPage}">
										<a class="btn btn-sm btn-primary"
											href="?name=${param.name}&page=${pageNum}&size=${size}">${pageNum}</a>
									</c:if>
								</c:forEach>

								<c:if test="${currentPage lt totalPages}">
									<a class="btn btn-sm btn-primary"
										href="?name=${param.name}&page=${currentPage + 1}&size=${size}">Next</a>
									<a class="btn btn-sm btn-primary"
										href="?name=${param.name}&page=${totalPages}&size=${size}">Last</a>
								</c:if>
							</div>
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