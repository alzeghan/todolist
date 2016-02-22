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
					<h2>Update Employee</h2>
				</div>

				<sf:form id="createEmployeeForm" action="/employee/update.do"
					method="post" class="form-horizontal" modelAttribute="emp">

					<fieldset>
					<sf:input type="hidden" path="id" disabled="disabled"/>

						<div class="control-group">
							<label class="control-label" for="name">Name:</label>
							<div class="controls">
								<sf:input type="text" class="inpbox" id="name" path="name"
									required="required" autofocus="autofocus" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="name">Title:</label>
							<div class="controls">
								<sf:input type="text" class="inpbox" id="title" path="title"
									required="required" autofocus="autofocus" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="name">Marital Status:</label>
							<div class="controls">
								<sf:select path="maritalStatus" class="form-control">
									<sf:option value="single" label="Single" />
									<sf:option value="married" label="Married" />
								</sf:select>
							</div>
						</div>
						
						 <div class="control-group">
                            <label class="control-label" for="name">Salary:</label>
                            <div class="controls">
                                <sf:input type="number"  class="inpbox" id="salary" path="salary" required="required" autofocus="autofocus" />
                            </div>
                        </div>
                        
                          <div class="control-group">
							<sf:label path="active" class="control-label">
							Status
						</sf:label>
							<div >
								<sf:radiobutton path="active" value="true" style="margin-left: 20px;"/>
								<span>Active</span>
								<sf:radiobutton path="active" value="false" style="margin-left: 20px;" />
								in-Active
							</div>
						</div>


						<div class="profile__footer form-actions">
							<button type="submit" class="btnsub">
								<i class="icon-ok icon-white"></i> Update
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
