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
            </div>

            <%@ include file="../common/error.jspf"%>
		<div class="profile--open">
		
		<sf:form method="post" action="login" modelAttribute="userBean">
                <fieldset>

                    
                        <div class="profile__fields well">
                        
                        <div class="field">
                            <sf:input path="username" id="username" type="text" class="input" placeholder="username" required="required"/>
                            <p class="help-block alert-error"><sf:errors path="username" cssClass="error"/></p>
                        
                        </div>
                    <div class="field">
                            <sf:input type="password" path="password" id="password" class="input" placeholder="min 6 characters" required="required"/>
                            <p class="help-block alert-error"><sf:errors path="password" cssClass="error"/></p>
                    </div>

                    
                    <div class="profile__footer">
                        <button type="submit" class="btnsub"><i class="icon-lock icon-white"></i> Login</button>
                        <div style="margin-top:5px;">
                        You don't have an account yet? <a href="/register">Register here!</a></div>
                    </div>

				</div>
                </fieldset>
            </sf:form>
		</div>
        </div>
    </div>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>
