<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tl" uri="emiratestodo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../common/header.jspf"%>

<div class="container">
	<div class="row">
		<div class="span3">
			<%@ include file="../common/sidebar.jspf"%>
		</div>
		<div class="span9">
			<div class="well" style="width:830px;">
				<div class="page-header">
					<h2>Tasks list <c:if test="${not empty taskList}">
                		<span style="float:right;">
                    		<button class="btn" onclick="javascript:window.print()">
                        		<i class="icon-print"></i>
                        		Print tasks list
                    		</button>
                		</span>
                	</c:if></h2>
				</div>
				
				<div class="panel-body"  style="margin-bottom: 10px;">
				<c:url value="create" var="create" />
				<span><a href="${create}" class="btnsub" style="padding: 10px;"> + New Task</a></span>
			</div>

				<div class="table-responsive">
					<table class="table table-hover table table-striped">
						<thead>
							<tr>
								<th width='25'>#</th>
								<th width='300'>Description</th>
								<th width="200">priority</th>
								<th width="150">Progress</th>
								<th width="200">Owner</th>
								<th width="200">Start Date</th>
								<th width="200">Due Date</th>
								<th width="135">Edit</th>
								<th width="143">delete</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${not empty taskList}">
								<c:forEach var="task" items="${taskList}" varStatus="counter">
									<tr style="cursor: pointer">
										<td>${counter.count}</td>
										<td>${task.description}</td>
										<td><i class="icon-circle-arrow-<tl:priorityIcon priority="${task.priority}"/>"></i> ${task.priority}</td>
										<td><span class="label <tl:statusStyle status="${task.status}"/> "> <tl:statusLabel status="${task.status}"/></span></td>
										<td>${task.assignedTo.name}</td>
										<td><fmt:formatDate value="${task.startDate}" pattern="dd/MM/yyyy"/></td>
										<td><fmt:formatDate value="${task.dueDate}" pattern="dd/MM/yyyy"/></td>
										<td>
											<c:url value="update" var="update">
											<c:param name="id" value="${task.id}" />
											</c:url> <a href="${update}"> <span class="label label-default" style="background-color:#006dcc;">Edit</span>
										</td>
										<td>
											<a class="btn btn-mini btn-danger" data-toggle="modal" href="#confirm_delete_${task.id}">Delete</a>
											<div class="modal hide" id="confirm_delete_${task.id}">
                                    			<div class="modal-header">
                                        			<button type="button" class="close" data-dismiss="modal">×</button>
                                        			<h3>Confirmation</h3>
                                    			</div>
                                    			<div class="modal-body">
                                        			<p>Are you sure to delete task ${task.id} '${task.description}' ?</p>
                                    			</div>
                                    			<div class="modal-footer">
                                        			<form action="/task/${task.id}/delete" method="post">
                                            			<a href="#" class="btn" data-dismiss="modal">Cancel</a> <button type="submit" class="btn btn-primary">Confirm</button>
                                        			</form>
                                    			</div>
                                			</div>
										</td>										
										
									</tr>
								</c:forEach>
							</c:if>

						</tbody>
						<tfoot>
                        <tr>
                            <td colspan="2"><div align="center">Total = <span class="badge badge-inverse">${totalCount}</span></div></td>
                            <td colspan="2"><div align="center">Todo = <span class="badge">${todoCount}</span></div></td>
                            <td colspan="2"><div align="center">Done = <span class="badge badge-success">${doneCount}</span></div></td>
                        </tr>
                    </tfoot>
					</table>
				</div>

			</div>
		</div>
	</div>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>
