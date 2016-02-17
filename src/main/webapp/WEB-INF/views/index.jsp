<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="common/header.jspf"%>

            <div class="wrapper">
                <div id="ei-slider" class="ei-slider">
                    <ul class="ei-slider-large">
						<li>
                            <img src="/static/img/large/6.jpg" alt="image06"/>
                            <div class="ei-title">
                                <h2 style="color:white;">More</h2>
                                <h3 style="color:white;font-size: 45px;">Productivity</h3>
                            </div>
                        </li>
                        
                        <li>
                            <img src="/static/img/large/2.jpg" alt="image02" />
                            <div class="ei-title">
                                <h2 style="color:white;">Team</h2>
                                <h3 style="color:white;font-size: 45px;">Work</h3>
                            </div>
                        </li>
                        <li>
                            <img src="/static/img/large/3.jpg" alt="image03"/>
                            <div class="ei-title">
                                <h2 style="color:white;">Take business</h2> 
                                <h3 style="color:white;font-size: 45px;">To next level</h3>
                            </div>
                        </li>
                        
                        <li>
                            <img src="/static/img/large/5.jpg" alt="image05"/>
                            <div class="ei-title">
                                <h2 style="color:white;">Save more</h2>
                                <h3>Time</h3>
                            </div>
                        </li>
                        <li>
                            <img src="/static/img/large/4.jpg" alt="image04"/>
                            <div class="ei-title">
                                <h2 style="color:white;">Limit</h2>
                                <h3 style="color:white;font-size: 45px;">Is the Sky!</h3>
                            </div>
                        </li>
                        <li>
                            <img src="/static/img/large/1.jpg" alt="image01" />
                            <div class="ei-title">
                                <h2 style="color:white;">Clear</h2>
                                <h3>Mind</h3>
                            </div>
                        </li>
                        <li>
                            <img src="/static/img/large/7.jpg" alt="image07"/>
                            <div class="ei-title">
                                <h2 style="color:white;">Easy to</h2>
                                <h3 style="color:white;font-size: 45px;">Track</h3>
                            </div>
                        </li>
                    </ul><!-- ei-slider-large -->
                    <ul class="ei-slider-thumbs">
                        <li class="ei-slider-element">Current</li>
						<li><a href="#">Slide 6</a><img src="/static/img/thumbs/6.jpg" alt="thumb06" /></li>
                        <li><a href="#">Slide 1</a><img src="/static/img/thumbs/2.jpg" alt="thumb01" /></li>
                        <li><a href="#">Slide 2</a><img src="/static/img/thumbs/3.jpg" alt="thumb02" /></li>
                        <li><a href="#">Slide 3</a><img src="/static/img/thumbs/5.jpg" alt="thumb03" /></li>
                        <li><a href="#">Slide 4</a><img src="/static/img/thumbs/4.jpg" alt="thumb04" /></li>
                        <li><a href="#">Slide 5</a><img src="/static/img/thumbs/1.jpg" alt="thumb05" /></li>
                        <li><a href="#">Slide 7</a><img src="/static/img/thumbs/7.jpg" alt="thumb07" /></li>
                    </ul><!-- ei-slider-thumbs -->
                </div><!-- ei-slider -->
                <div class="reference">
					<p>Keep tracking your business</p>
					<c:if test="${sessionScope['scopedTarget.sessionData'].user == null}">
                    <p>
                        <a class="btnsub btn-large" style="padding:11px 19px;margin-right:5px;" href="/login"> Sign in </a> | <a class="btnsub btn-large" style="background-color:#006dcc;padding:11px 19px;" href="/register"> Sign up </a>
                    </p>
                    </c:if>

                    <c:if test="${sessionScope['scopedTarget.sessionData'].user != null}">
                        <p>
                            <a style="padding-bottom: 20px; padding-top: 20px;" class="btnsub" href="/user/todos"> My todo list >> </a>
                        </p>
                    </c:if>
                </div>
            </div><!-- wrapper -->
        
		<script type="text/javascript" src="/static/js/jquery.eislideshow.js"></script>
        <script type="text/javascript" src="/static/js/jquery.easing.1.3.js"></script>
        <script type="text/javascript">
            $(function() {
                $('#ei-slider').eislideshow({
					animation			: 'center',
					autoplay			: true,
					slideshow_interval	: 3000,
					titlesFactor		: 0
                });
            });
        </script>
            
<%@ include file="common/footer.jspf"%>
