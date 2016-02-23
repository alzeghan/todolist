<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../common/header.jspf"%>
<%--content--%>

<div class="container">

    <div class="row">
        <div class="span6 offset3">
            <div class="page-header">
                <h1>Login</h1>
                <%@ include file="../common/error.jsp"%>
							<c:if test="${param.logout != null}">
								<div class="alert alert-success" style="width:390px;">
									<p>You have been logged out successfully.</p>
								</div>
							</c:if>
				<div class="profile--open">
                	<c:url var="loginUrl" value="/login" />
						<form action="${loginUrl}" method="post">
							<div class="profile__fields well" style="width:400px;">
							
								<div class="field">
									<input type="text" class="input" id="ssoId" name="ssoId" placeholder="Enter Username" required>
									<p class="help-block alert-error"><sf:errors path="username" cssClass="error"/></p>
								</div>
								<div class="field">
									<input type="password" class="input" id="password" name="password" placeholder="Enter Password" required>
									<p class="help-block alert-error"><sf:errors path="password" cssClass="error"/></p>
								</div>
									<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
								
								<div class="profile__footer">
									<button type="submit" class="btnsub"><i class="icon-lock icon-white"></i> Login</button>
									<div style="margin-top:5px;">You don't have an account yet? <a href="/register">Register here!</a></div>
									
								</div>
							</div>
            			</form>
				</div>
			</div>
		</div>
	</div>
</div>
<%--end content--%>
<%@ include file="../common/footer.jspf"%>
