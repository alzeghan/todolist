<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="common/header.jspf"%>
<%--content--%>

<style>
.col-centered {
	float: none;
	margin: 0 auto;
}

.vertical-center {
	min-height: 100%; /* Fallback for browsers do NOT support vh unit */
	min-height: 100vh; /* These two lines are counted as one :-)       */
	display: flex;
	align-items: center;
}
</style>

<div class="container ">
	<c:url value="home" var="homepage" />
	<div class="row centered text-center vertical-center">
		<div class="col-md-12 col-centered">
			<div class="error-template">
				<h1>Oops!</h1>
				<h2>Some Thing Went Wrong</h2>
				<div class="error-details">Sorry, an error has occured,
					Requested page not found! ${message}</div>
				<div class="error-actions">
					<a href="${homepage}" class="btn btn-primary btn-lg"> Take Me
						Home </a>
				</div>
			</div>
		</div>
	</div>

</div>

<%--end content--%>
<%@ include file="common/footer.jspf"%>
