<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-paper.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jquery/jquery-2.1.4.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<title><sitemesh:write property="title" /></title>
<style type="text/css">
.verticalLine {
	border-left: thick solid #F0F0F0;
}
</style>
<sitemesh:write property="head" />
</head>
<body>
	<jsp:include page="../parts/navbar.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-md-10">
				<jsp:include page="../parts/alerts.jsp"></jsp:include>
				<sitemesh:write property="body" />
			</div>
			<div class="col-md-2 verticalLine">
				<center>


					<table >
						<tbody>
							<tr>
								<td bgcolor="#FFFFFF"><font size="2" face="tahoma"
									color="#000066"> <br>
								</font> <font size="2" color="#000066">
										<h3 align="center">
											<font size="4">Diamond Lifetime Membership <br> <b><span
													style="background-color: #FFFF00"> </span></b> <font
												color="#000000" size="2"><b> <span
														style="background-color: #FFFF00"></span>
												</b></font>
											</font>
											<center>
												<font size="4">
													<p>100000 points on joining</p>
													<p>35 points for every ad read</p>
													<p>300 points for every solo ad click</p>
													<p>300 points for every referral</p>
													<p>Post 12 times a day</p>
													<p>
														Price: <b>$79.95 Lifetime</b>
													</p>
												</font> <b>Sign Up Free, Then Upgrade Inside!</b><br>



											</center>

										</h3>
								</font></td>
							</tr>
						</tbody>
					</table>
					<br> <br>


					<table>
						<tbody>
							<tr>
								<td bgcolor="#FFFFFF"><font size="2" face="tahoma"
									color="#000066"> <br>
								</font> <font size="2" color="#000066">
										<h3 align="center">
											<font size="4">Pro Monthly Membership <br> <b><span
													style="background-color: #FFFF00"> </span></b> <font
												color="#000000" size="2"><b> <span
														style="background-color: #FFFF00"></span>
												</b></font>
											</font>
											<center>
												<font size="4">
													<p>40000 points on joining</p>
													<p>25 points for every ad read</p>
													<p>200 points for every solo ad click</p>
													<p>100 points for every referral</p>
													<p>Post 5 times a day</p>
													<p>
														Price: <b>$4.95 Monthly</b>
													</p>
												</font> <b>Sign Up Free, Then Upgrade Inside!</b><br>



											</center>

										</h3>
								</font></td>
							</tr>
						</tbody>
					</table>
					<br> <br>

					<center>
						<center>
							<table>
								<tbody>
									<tr>
										<td bgcolor="#FFFFFF"><font size="2" color="#000066">
										</font>
											<h3 align="center">
												<font size="2" color="#000066"><font size="4">

														Free Membership</font></font>
												<center>
													<font size="2" color="#000066"><font size="4">
															<p>20000 points on joining</p>
															<p>10 points for every ad read</p>
															<p>100 points for every solo ad click</p>
															<p>50 points for every referral</p>
															<p>Post 1 time(s) a day</p>
													</font></font>
													<center>
														<font size="2" color="#000066"><font size="4">
																<p align="center">
																	Price: <b>FREE</b>
																</p>
														</font> <font size="2" face="tahoma" color="#000066"> </font></font>
														<form method="POST" action="join.php">
															<font size="2" color="#000066"><font size="2"
																face="tahoma" color="#000066"> </font></font>
															<p align="center">
																<font size="2" color="#000066"><font size="2"
																	face="tahoma" color="#000066"> <br> <br>
																		Free Members Signup <br> <br>Username (no
																		spaces):<br> <input type="text" size="25"
																		name="new_userid"></font> <br>Password:<br>
																	<input type="text" size="25" value=""
																	name="new_password"> <br>Retype Password:<br>
																	<input type="text" size="25" value=""
																	name="new_passwordv"> <br>Full Name:<br>
																	<input type="text" size="25" name="new_fullname">
																	<br>Email:<br> <input type="text" size="25"
																	name="new_contact"> <br> </font>
															</p>

															<center>
																<font size="2" color="#000066">

																	<p>
																		<font color="#FF0000">NOTE: Don't use hotmail,
																			yahoo, aol, earthlink, sbcglobal. USE ONLY gmail.com.</font>
																	</p>

																	<p>
																		<font size="2" color="#000066">Member Type:<br>
																			<b>Free</b></font>
																	</p> <font size="2" color="#000066"> </font> <font size="2"
																	face="tahoma" color="#000066">

																		<p>
																			<font face="Verdana" color="#000000"> <input
																				type="submit" value="Create Account"></font>
																		</p>
																</font> <font size="2" color="#000066"> By joining you
																		agree to receive emails from TrafficAdLinks.com. You
																		are also agreeing to the rest of our <a
																		href="http://www.trafficadlinks.com/terms.php"
																		target="_blank&quot;"> <font color="#000000"><u>Terms
																					and Conditions</u></font></a>
																</font>
																</font>
															</center>
														</form>
														<font size="2" color="#000066"><font size="2"
															color="#000066"> </font> <font size="2" face="tahoma"
															color="#000066"> </font></font>
													</center>
													<font size="2" color="#000066"><font size="2"
														face="tahoma" color="#000066"> </font> </font>
												</center>
											</h3></td>
									</tr>
								</tbody>
							</table>
							<br> <br>
						</center>
					</center>
				</center>
			</div>
		</div>
	</div>
</body>
</html>
