
<%@ include file="../Banner/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style type="text/css">
.colorRed {
	color: red;
}

#imagePreview {
	width: 200px;
	height: 200px;
	border: 2px solid #ddd;
	border-radius: 5px;
	display: flex;
	justify-content: center;
	align-items: center;
	overflow: hidden;
	cursor: pointer; /* Add cursor pointer for better UX */
}

#imagePreview img {
	max-width: 100%;
	max-height: 100%;
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
							<h3 style="color: red">${err}</h3>
							<form:form action="insertProduct" method="post"
								modelAttribute="p" enctype="multipart/form-data">
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label">Tên</label>
											<form:input path="name" class="form-control" />
											<form:errors cssClass="colorRed" path="name"></form:errors>
										</div>
										<div class="form-group">
											<label class="control-label">Giá</label>
											<form:input path="price" class="form-control" />
											<form:errors cssClass="colorRed" path="price"></form:errors>
										</div>
										<div class="form-group">
											<label class="control-label">Trạng thái</label>
											<form:radiobutton path="status" value="true" />
											Hiện
											<form:radiobutton path="status" value="false" />
											Ẩn
											<form:errors cssClass="colorRed" path="status"></form:errors>
										</div>
									</div>
									<div class="col-md-8">
										<div class="form-group">
											<label class="control-label">Image</label>
											<form:input id="fileInput" class="form-control" type="file"
												path="fileUpload" />
											<div id="imagePreview"
												onclick="document.getElementById('fileInput').click();">
												<img src="no-image-available.png" alt="No Image Available">
											</div>
											<form:errors cssClass="colorRed" path="fileUpload"></form:errors>
										</div>
										<div class="form-group">
											<label class="control-label">Danh mục</label>
											<form:select class="form-control" path="categoryId.id">
												<form:option value="">-----mời chọn-----</form:option>
												<form:options items="${c}" itemLabel="name" itemValue="id" />
											</form:select>
											<form:errors cssClass="colorRed" path="categoryId"></form:errors>
										</div>
										<div class="form-group">
											<label class="control-label">Description</label>
											<form:textarea path="description" class="form-control" />
											<form:errors cssClass="colorRed" path="description"></form:errors>
										</div>
									</div>
								</div>
								<div class="form-group">
									<input type="submit" class="btn btn-primary" /> <a
										href="${pageContext.request.contextPath}/admin/product/"
										class="btn btn-danger">Back to List</a>
								</div>
							</form:form>
						</div>

					</div>
					<div class="card-body table-responsive p-0"></div>
				</div>


			</div>
			<!-- /.card -->
		</div>
	</div>
</div>
</div>
<script>
	const fileInput = document.getElementById('fileInput');
	const imagePreview = document.getElementById('imagePreview');
	const defaultImageUrl = 'no-image-available.png'; // Đường dẫn đến hình ảnh mặc định

	fileInput
			.addEventListener(
					'change',
					function() {
						const file = this.files[0];

						if (file) {
							const reader = new FileReader();

							reader.onload = function() {
								const imageUrl = reader.result;
								const img = document.createElement('img');
								img.src = imageUrl;
								imagePreview.innerHTML = '';
								imagePreview.appendChild(img);
							};

							reader.readAsDataURL(file);
						} else {
							imagePreview.innerHTML = `<img src="rocket.png" alt="No Image Available">`;
						}
					});
</script>
<!-- /.content-wrapper -->

<!-- Control Sidebar -->
<aside class="control-sidebar control-sidebar-dark">
	<!-- Control sidebar content goes here -->
</aside>
<!-- /.control-sidebar -->
<%@ include file="../Banner/footer.jsp"%>
