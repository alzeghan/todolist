<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jspf" %>

<div class="container">
    <div class="row">
        <div class="span3">
            <%@ include file="../common/sidebar.jspf" %>
        </div>
        <div class="span9">
            <div class="well">
                <div class="page-header">
                   
                    <img height="100px" width="150px" src="/static/img/my_profile.jpg" alt="my profile" />
                     <h3>Update my profile</h3>
                </div>

                <%@ include file="../common/error.jsp"%>

                <div class="row">
                    <div class="span8">
                        <form action="/account/update.do" method="post" class="form-horizontal">
                            <fieldset>
                                <div class="control-group">
                                    <label class="control-label" for="id">Id:</label>

                                    <div class="controls">
                                        <input name="id" id="id" value="${user.id}" type="text" class="inpbox" disabled="disabled"/>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="firstName">First Name:</label>

                                    <div class="controls">
                                        <input name="firstName" id="firstName" value="${user.firstName}" type="text" class="inpbox" required="required"/>
                                    </div>
                                </div>
                                
                                <div class="control-group">
                                    <label class="control-label" for="lastName">Last Name:</label>

                                    <div class="controls">
                                        <input name="lastName" id="lastName" value="${user.lastName}" type="text" class="inpbox" required="required"/>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="username">Username:</label>

                                    <div class="controls">
                                        <input name="username" id="username" value="${user.username}" type="text" class="inpbox" required="required"/>
                                    </div>
                                </div>

                                <div class="form-actions">
                                    <button type="submit" class="btnsub"><i class="icon-refresh icon-white"></i> Update my profile</button>
                                </div>

                            </fieldset>
                        </form>
                    </div>
                </div>

                <div class="row">
                    <div class="span8">
                        <form action="/account/password.do" method="post" class="form-horizontal" modelAttribute="changePasswordDTO">

                            <fieldset>

                                <legend>Update my Password <p class="alert-success">${updatePasswordSuccessMessage}</p></legend>

                                <div class="control-group">
                                    <label class="control-label" for="currentPassword">Current password:</label>

                                    <div class="controls">
                                        <input type="password" id="currentPassword" value="${changePasswordDTO.currentPassword}" class="inpbox"  placeholder="min 6 characters" required="required"/>
                                        
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="newPassword">New password:</label>

                                    <div class="controls">
                                        <input type="password" id="newPassword" value="${changePasswordDTO.newPassword}" class="inpbox"  placeholder="min 6 characters" required="required"/>
                                        
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="confirmationPassword">Confirmation password:</label>

                                    <div class="controls">
                                        <input type="password" id="confirmationPassword" value="${changePasswordDTO.confirmationPassword}" class="inpbox"  placeholder="min 6 characters" required="required"/>
                                        
                                    </div>
                                </div>

                                <div class="form-actions">
                                    <button type="submit" class="btnsub"><i class="icon-refresh icon-white"></i> Update my password</button>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>

                <div class="row">
                    <div class="span8">
                        <fieldset>
                            <legend>Delete my account</legend>
                            <div class="alert alert-block alert-error fade in">
                                <p>You are about to remove your account. This will completely
                                    delete all your data.</p>
                                <p>
                                    <a class="btndel" data-toggle="modal" href="#deleteAccountLink"> <i class="icon-remove icon-white"></i> Delete my account</a>
                                </p>
                                <div class="modal hide" id="deleteAccountLink">
                                    <div class="modal-header">
                                        <h3>Confirmation</h3>
                                    </div>
                                    <div class="modal-body">
                                        <p>Are you sure to delete your account?</p>
                                    </div>
                                    <div class="modal-footer">
                                        <form class="form-horizontal" method="post" action="/account/delete.do">
                                            <p>
                                                <a href="#" class="btn" data-dismiss="modal">No, I'm not sure</a>
                                                <button type="submit" class="btn btn-danger">Yes, I do confirm!</button>
                                            </p>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf" %>
