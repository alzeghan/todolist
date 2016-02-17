<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- <%@ taglib prefix="tl" uri="emiratestodo" %> --%>
<%@ include file="../common/header.jspf"%>

<div class="container">
    <div class="row">
        <div class="span3">
            <%@ include file="../common/sidebar.jspf"%>
        </div>
        <div class="span9">
            <div class="well">
                <div class="page-header">
                    <h2>Todo list <c:if test="${not empty requestScope.todoList}">
                		<span style="float:right;">
                    		<button class="btn" onclick="javascript:window.print()">
                        		<i class="icon-print"></i>
                        		Print todo list
                    		</button>
                		</span>
                	</c:if></h2>
                    
                </div>
                
<span><a href="/user/todos/new" class="btnsub" style="padding: 10px;"> + Create a todo</a></span>
                <table class="table table-bordered table-striped">

                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Due Date</th>
                        <th>Priority</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${todoList}" var="currentTodo">
                        <tr>
                            <td>${currentTodo.id}</td>
                            <td>${currentTodo.title}</td>
                            <td><fmt:formatDate value="${currentTodo.dueDate}" pattern="dd/MM/yyyy"/></td>
                            <td><i class="icon-circle-arrow-<tl:priorityIcon priority="${currentTodo.priority}"/>"></i> ${currentTodo.priority}</td>
                            <td><span class="label <tl:statusStyle status="${currentTodo.done}"/> "> <tl:statusLabel status="${currentTodo.done}"/></span></td>
                            <td>
                                <a class="btn btn-mini btn-primary" href="/user/todos/${currentTodo.id}/update"><i class="icon-edit icon-white"></i> Edit</a>
                                <a class="btn btn-mini btn-danger" data-toggle="modal" href="#confirm_delete_${currentTodo.id}"><i class="icon-remove icon-white"></i> Delete</a>
                                <div class="modal hide" id="confirm_delete_${currentTodo.id}">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">×</button>
                                        <h3>Confirmation</h3>
                                    </div>
                                    <div class="modal-body">
                                        <p>Are you sure to delete todo ${currentTodo.id} '${currentTodo.title}' ?</p>
                                    </div>
                                    <div class="modal-footer">
                                        <form action="/user/todos/${currentTodo.id}/delete" method="post">
                                            <a href="#" class="btn" data-dismiss="modal">Cancel</a> <button type="submit" class="btn btn-primary">Confirm</button>
                                        </form>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="2"><div align="center">Total = <span class="badge badge-inverse">${requestScope.totalCount}</span></div></td>
                            <td colspan="2"><div align="center">Todo = <span class="badge">${requestScope.todoCount}</span></div></td>
                            <td colspan="2"><div align="center">Done = <span class="badge badge-success">${requestScope.doneCount}</span></div></td>
                        </tr>
                    </tfoot>
                </table>

                <c:if test="${empty requestScope.todoList}">
                    <div class="alert alert-info">
                        <div align="center">Your todo list is empty !</div>
                    </div>
                </c:if>

            </div>
        </div>
    </div>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>
