<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jspf"%>

<div class="container">
    <div class="row">
        <div class="span3">
            <%@ include file="../common/sidebar.jspf"%>
        </div>
        <div class="span9">
            <div class="well">
                <div class="page-header">
                    <h2>Update Task</h2>
                </div>

                <sf:form id="createTaskForm" action="/task/update.do" method="post" class="form-horizontal" modelAttribute="task">

                    <fieldset>
                    <sf:input type="hidden" path="id" disabled="disabled"/>
                    	<div class="control-group">
							<label class="control-label" for="name">Description:</label>
							<div class="controls">
								<sf:input type="text" class="input" id="description" path="description"
									required="required" autofocus="autofocus" />
							</div>
						</div>
							
						<div class="control-group">
							<label class="control-label" for="employee">Assign To:</label>
							<div class="controls">
							
									<form:select path="assignedTo.id">
					  					<form:options items="${allEmployees}" itemValue="id" itemLabel="name"/>
				       				</form:select>
							
							</div>
						</div>
							<div class="control-group">
							<label class="control-label" for="building">Building:</label>
							<div class="controls">
							
									<form:select path="building.id">
					  					<form:options items="${allBuildings}" itemValue="id" itemLabel="name"/>
				       				</form:select>
							
							</div>
						</div>
								
						<div class="control-group">
                            <label class="control-label" for="status">Progress:</label>
							
							<div class="controls">
                                <sf:select id="status" path="status">
                                  <sf:option value="true">Done</sf:option>
                                  <sf:option value="false">Todo</sf:option>
                              </sf:select>
                            </div>
							
							</div>
						
							
							
						<div class="control-group">
                            <label class="control-label" for="priority">Priority:</label>
                            <div class="controls">
                                <sf:select id="priority" path="priority">
                                  <sf:option value="LOW">Low</sf:option>
                                  <sf:option value="MEDIUM">Medium</sf:option>
                                  <sf:option value="HIGH">High</sf:option>
                                </sf:select>
                            </div>
                        </div>
							
						<div class="control-group">
                            <label class="control-label" for="startDate">Due date:</label>
                            <div class="controls">
                                <sf:input type="text" class="inpbox" id="startDate" path="startDate" value="${today}" required="required" />
                            </div>
                        </div>
							
						<div class="control-group">
                            <label class="control-label" for="dueDate">Start date:</label>
                            <div class="controls">
                                <sf:input type="text" class="inpbox" id="dueDate" path="dueDate" value="${today}" required="required" />
                            </div>
                        </div>
							
						
						<div class="form-group hide">
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


 
						<div class="profile__footer form-actions" >
                            <button type="submit" class="btnsub"> <i class="icon-ok icon-white"></i> Update</button>
                            <button type="button" class="btncancel" onclick="history.go(-1)"><i class="icon-remove"></i> Cancel</button>
                        </div>

                    </fieldset>


                </sf:form>

            </div>
        </div>
    </div>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>
