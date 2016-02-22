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
					<h2>Create a new todo</h2>
				</div>

				<sf:form id="createTodoForm" action="/building/create.do"
					method="post" class="form-horizontal" modelAttribute="building">

					<fieldset>

						<div class="control-group">
							<label class="control-label" for="name">Title:</label>
							<div class="controls">
								<sf:input type="text" class="inpbox" id="name" path="name"
									required="required" autofocus="autofocus" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="location">Location:</label>
							<div class="controls">
								<sf:input type="text" class="inpbox" id="location"
									path="location" required="required" />
							</div>
						</div>

						<div class="form-group">
							<sf:label path="active" class="control-label">
							Active/in-active
						</sf:label>
							<sf:radiobutton path="active" value="true" />
							Active
							<sf:radiobutton path="active" value="false" />
							in-Active
						</div>


						<div class="profile__footer form-actions">
							<button type="submit" class="btnsub">
								<i class="icon-ok icon-white"></i> Create
							</button>
							<button type="button" class="btncancel" onclick="history.go(-1)">
								<i class="icon-remove"></i> Cancel
							</button>
						</div>

					</fieldset>


				</sf:form>

			</div>
		</div>
	</div>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>
