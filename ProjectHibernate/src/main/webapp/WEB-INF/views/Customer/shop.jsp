<%@ include file="/header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="hero-wrap hero-bread"
	style="background-image: url('${pageContext.request.contextPath}/resources/customer/images/bg_1.jpg');">
	<div class="container">
		<div
			class="row no-gutters slider-text align-items-center justify-content-center">
			<div class="col-md-9 ftco-animate text-center">
				<p class="breadcrumbs">
					<span class="mr-2"><a href="index.html">Home</a></span> <span>Products</span>
				</p>
				<h1 class="mb-0 bread">Products</h1>
			</div>
		</div>
	</div>
</div>

<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-10 mb-5 text-center">
				<ul class="product-category">
					<li><a href="#" class="active">All</a></li>
					<c:forEach items="${c}" var="c">
						<li><a href="#">${c.name}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="row">
			<c:forEach items="${pro}" var="pro">
				<div class="col-md-6 col-lg-3 ftco-animate">
					<div class="product">
						<a href="product_single/details?id=${pro.id}" class="img-prod"><img class="img-fluid"
							src="${pageContext.request.contextPath}/resource/Test/${pro.image}"
							alt="Colorlib Template">
							<div class="overlay"></div> </a>
						<div class="text py-3 pb-4 px-3 text-center">
							<h3>
								<a href="#">${pro.name }</a>
							</h3>
							<div class="d-flex">
								<div class="pricing">
									<p class="price">
										<span class="mr-2 price-dc">$120.00</span><span
											class="price-sale">$80.00</span>
									</p>
								</div>
							</div>
							<div class="bottom-area d-flex px-3">
								<div class="m-auto d-flex">
									<a href="#"
										class="add-to-cart d-flex justify-content-center align-items-center text-center">
										<span><i class="ion-ios-menu"></i></span>
									</a> <a href="#"
										class="buy-now d-flex justify-content-center align-items-center mx-1">
										<span><i class="ion-ios-cart"></i></span>
									</a> <a href="#"
										class="heart d-flex justify-content-center align-items-center ">
										<span><i class="ion-ios-heart"></i></span>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<div class="text-center row mt-5">
		<div class="col text-center">
			<div class="block-27">
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
	
</section>

<section class="ftco-section ftco-no-pt ftco-no-pb py-5 bg-light">
	<div class="container py-4">
		<div class="row d-flex justify-content-center py-5">
			<div class="col-md-6">
				<h2 style="font-size: 22px;" class="mb-0">Subcribe to our
					Newsletter</h2>
				<span>Get e-mail updates about our latest shops and special
					offers</span>
			</div>
			<div class="col-md-6 d-flex align-items-center">
				<form action="#" class="subscribe-form">
					<div class="form-group d-flex">
						<input type="text" class="form-control"
							placeholder="Enter email address"> <input type="submit"
							value="Subscribe" class="submit px-3">
					</div>
				</form>
			</div>
		</div>
	</div>
</section>
<%@ include file="/footter.jsp"%>