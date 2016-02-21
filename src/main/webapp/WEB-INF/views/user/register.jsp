<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jspf"%>
<%--content--%>

<div class="container">

    <div class="row">
        <div class="span6 offset3">
            <div class="page-header">
                <h1>Register</h1>
            </div>
			<div class="profile--open">
            <sf:form method="post" modelAttribute="userDTO" action="/register.do">

                <%@ include file="../common/error.jsp"%>

                <fieldset>
				<div class="profile__fields well">
				
				
                    <div class="field">
                        <div class="controls">
                            <sf:input path="firstName" id="firstName" type="text" class="input" placeholder="First Name" required="required"/>
                            <p class="help-block alert-error"><sf:errors path="firstName" cssClass="error"/></p>
                        </div>
                    </div>

					<div class="field">
                        <div class="controls">
                            <sf:input path="lastName" id="lastName" type="text" class="input" placeholder="Last Name" required="required"/>
                            <p class="help-block alert-error"><sf:errors path="lastName" cssClass="error"/></p>
                        </div>
                    </div>
                    <div class="field">
                        <div class="controls">
                            <sf:input path="username" id="username" type="text" class="input" placeholder="Username" required="required"/>
                            <p class="help-block alert-error"><sf:errors path="username" cssClass="error"/></p>
                        </div>
                    </div>

                    <div class="field">
                        
                        <div class="controls">
                            <sf:input type="password" path="password" id="password" class="input" placeholder="Password min 6 characters" required="required"/>
                            <p class="help-block alert-error"><sf:errors path="password" cssClass="error"/></p>
                        </div>
                    </div>

                    <div class="field">
                        
                        <div class="controls">
                            <sf:input type="password" path="matchingPassword" id="matchingPassword" class="input" placeholder="Confirm password" required="required"/>
                            <p class="help-block alert-error"><sf:errors path="matchingPassword" cssClass="error"/></p>
                        </div>
                    </div>

                    <div class="profile__footer">
                        <button type="submit" class="btnsub"><i class="icon-lock icon-white"></i> Register</button>
                    </div>

                   <div style="margin-top:5px;">
                        You have already an account? <a href="/login">Sign in here</a>
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