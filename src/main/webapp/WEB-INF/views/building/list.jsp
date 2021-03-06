<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../common/header.jspf"%>

<div class="container">
	<div class="row">
		<div class="span3">
			<%@ include file="../common/sidebar.jspf"%>
		</div>
		<div class="span9">
			<div class="well">
				<div class="page-header">
					<h2>Building Management</h2>
				</div>
				
				<div class="panel-body">
				<c:url value="create" var="create" />
				<span><a href="${create}" class="btnsub" style="padding: 10px;"> + New BUILDING</a></span>
				</a>
			</div>

				<div class="table-responsive">
					<table class="table table-hover table table-striped">
						<thead>
							<tr>
								<th width='25'>#</th>
								<th width='300'>Name</th>
								<th width="200">Location</th>
								<th>Edit</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${not empty buildingList}">
								<c:forEach var="building" items="${buildingList}"
									varStatus="counter">
									<tr style="cursor: pointer">
										<td>${counter.count}</td>
										<td>${building.name}</td>
										<td>${building.location}</td>
										<td><c:url value="update" var="update">
											<c:param name="id" value="${building.id}" />
										</c:url> <a href="${update}"> <span
											class="label label-default" style="background-color:#006dcc;">Edit</span></td>
									</tr>
								</c:forEach>
							</c:if>

						</tbody>
					</table>
				</div>

			</div>
		</div>
	</div>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>
