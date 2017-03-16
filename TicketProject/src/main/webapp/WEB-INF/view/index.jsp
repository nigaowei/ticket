<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<title>工单质检系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<!-- STYLESHEETS --><!--[if lt IE 9]><script src="js/flot/excanvas.min.js"></script><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script><![endif]-->
	<link rel="stylesheet" type="text/css" href="css/cloud-admin.css" >
	<link rel="stylesheet" type="text/css"  href="css/themes/default.css" id="skin-switcher" >
	<link rel="stylesheet" type="text/css"  href="css/responsive.css" >
	
	<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">
	<!-- DATE RANGE PICKER -->
	<link rel="stylesheet" type="text/css" href="js/bootstrap-daterangepicker/daterangepicker-bs3.css" />
	<!-- TABLE CLOTH -->
	<link rel="stylesheet" type="text/css" href="js/tablecloth/css/tablecloth.min.css" />
	<link rel="stylesheet" type="text/css" href="css/type.css" />
	
</head>
<body>
	<!-- HEADER -->
	<header class="navbar clearfix" id="header">
		<div class="container">
				<div class="navbar-brand">
					<!-- COMPANY LOGO -->
					<a href="index.html">
						<img src="img/logo/logo.png" alt="Cloud Admin Logo" class="img-responsive" height="30" width="120">
					</a>
					<!-- /COMPANY LOGO -->
					<!-- TEAM STATUS FOR MOBILE -->
					<div class="visible-xs">
						<a href="#" class="team-status-toggle switcher btn dropdown-toggle">
							<i class="fa fa-users"></i>
						</a>
					</div>
					<!-- /TEAM STATUS FOR MOBILE -->
					<!-- SIDEBAR COLLAPSE -->
					<div id="sidebar-collapse" class="sidebar-collapse btn">
						<i class="fa fa-bars" 
							data-icon1="fa fa-bars" 
							data-icon2="fa fa-bars" ></i>
					</div>

				</div>
				<!-- NAVBAR LEFT -->

				<!-- /NAVBAR LEFT -->
				<!-- BEGIN TOP NAVIGATION MENU -->					

				<!-- END TOP NAVIGATION MENU -->
		</div>
		
		<!-- TEAM STATUS -->

		<!-- /TEAM STATUS -->
	</header>
	<!--/HEADER -->
	
	<!-- PAGE -->
	<section id="page">
				<!-- SIDEBAR -->
				<div id="sidebar" class="sidebar">
					<div class="sidebar-menu nav-collapse">
						<div class="divide-20"></div>
						<!-- SEARCH BAR -->
						<div id="search-bar">
							<input class="search" type="text" placeholder="Search"><i class="fa fa-search search-icon"></i>
						</div>
						<!-- /SEARCH BAR -->
						
						<!-- SIDEBAR QUICK-LAUNCH -->
						<!-- <div id="quicklaunch">
						<!-- /SIDEBAR QUICK-LAUNCH -->
						
						<!-- SIDEBAR MENU -->
						<ul>
							<li>
								<a href="#">
								<i class="fa fa-tachometer fa-fw"></i> <span class="menu-text">工单质检</span>
								<span class="selected"></span>
								</a>					
							</li>

						</ul>
						<!-- /SIDEBAR MENU -->
					</div>
				</div>
				<!-- /SIDEBAR -->
		<div id="main-content">
			<!-- SAMPLE BOX CONFIGURATION MODAL FORM-->

			<!-- /SAMPLE BOX CONFIGURATION MODAL FORM-->
			<div class="container">
				<div class="row">
					<div id="content" class="col-lg-12">
						<!-- PAGE HEADER-->
						<div class="row">
							<div class="col-sm-12">
								<div class="page-header">
									<!-- STYLER -->
									
									<!-- /STYLER -->
									<!-- BREADCRUMBS -->
									<ul class="breadcrumb">
										<li>
											<i class="fa fa-home"></i>
											<a href="index.html">Home</a>
										</li>
										<li>
											<a href="#">工单质检</a>
										</li>
									</ul>
									<!-- /BREADCRUMBS -->

									<form class="navbar-form navbar-left" role="search"   method="POST" enctype="multipart/form-data">
										<table cellpadding="10px" cellspacing="0px">
											<tr >
												<td>
													<div class="input-group">
														<span class="input-group-addon">工单</span>
														<input  style="width:180px;height:35px"  id="fileToUpload" name="file" type="file" class="input"/>

													</div>
												</td>
												<td>
													<div class="input-group">
														<span class="input-group-addon">原因不明时间间隔</span>
														<input type="search" placeholder="天" class="form-control" style="width:60px; height:35px"  id="num1" name="num1"/>
													</div>
												</td>
												<td>
													<div class="input-group">
														<span class="input-group-addon">闪断告警时间间隔</span>
														<input type="search" placeholder="分钟" class="form-control" style="width:60px; height:35px"  name="num2" id="num2" />
													</div>
												</td>


											</tr>

										</table>



									</form>

									<div class="input-group enter">
										<button style="height: 35px"  class="check">开始质检</button>
									</div>

								</div>

							</div>

						</div>
						<!-- /PAGE HEADER -->
						<!-- SIMPLE STRIPED -->

						<div class="row">
							<div class="col-md-12">
								<!-- BOX -->
								<div class="box border green">
									<div class="box-title">
										<h4><i class="fa fa-bar-chart-o"></i>质检结果</h4>
										<div class="tools">

											<a href="javascript:;" class="collapse">
												<i class="fa fa-chevron-up"></i>
											</a>

										</div>
									</div>
									<div class="box-body">
										<div   style="height:225px;overflow:scroll;">

											<table  class="example-paper table0" cellspacing="0"  align="center">
												<thead>
												<tr>
													<th>工单总数</th>
													<th>未处理工单</th>
													<th>不合格工单</th>
													<th>合格工单</th>
													<th>高风险工单</th>
												</tr>
												</thead>
												<tbody>

												</tbody>
											</table>

										</div>
									</div>

								</div>
								<!-- /BOX -->
							</div>
						</div>






						<!-- DARK & STATS -->
						<!-- /BORDERED HOVER -->
						<div class="row">
							<div class="col-md-12">
								<!-- BOX -->
								<div class="box border green">
									<div class="box-title">
										<h4><i class="fa fa-bar-chart-o"></i>告警原因与处理措施逻辑不匹配</h4>
										<div class="tools">

											<a href="javascript:;" class="collapse">
												<i class="fa fa-chevron-up"></i>
											</a>

										</div>
									</div>
									<div class="box-body">
										<div   style="height:225px;overflow:scroll;">

											<table  class="example-paper table1" cellspacing="0"  align="center">
												<thead>
												<tr>
													<th>工单流水号</th>
													<th>原因分类</th>
													<th>原因细分</th>
													<th>故障原因</th>
													<th>处理措施</th>
												</tr>
												</thead>
												<tbody>

												</tbody>
											</table>

										</div>
									</div>

								</div>
								<!-- /BOX -->
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<!-- BOX -->
								<div class="box border green">
									<div class="box-title">
										<h4><i class="fa fa-bar-chart-o"></i>告警与故障原因逻辑不匹配</h4>
										<div class="tools">

											<a href="javascript:;" class="collapse">
												<i class="fa fa-chevron-up"></i>
											</a>

										</div>
									</div>
									<div class="box-body">
										<div   style="height:225px;overflow:scroll;">

											<table class="example-paper table2" cellspacing="0"  align="center">
												<thead>
												<tr>
													<th>工单流水号</th>
													<th>告警标题</th>
													<th>原因分类</th>
													<th>原因细分</th>
													<th>故障原因</th>

												</tr>
												</thead>
												<tbody>

												</tbody>
											</table>

										</div>
									</div>

								</div>
								<!-- /BOX -->
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<!-- BOX -->
								<div class="box border green">
									<div class="box-title">
										<h4><i class="fa fa-bar-chart-o"></i>高风险：告警原因与处理措施</h4>
										<div class="tools">

											<a href="javascript:;" class="collapse">
												<i class="fa fa-chevron-up"></i>
											</a>

										</div>
									</div>
									<div class="box-body">
										<div   style="height:225px;overflow:scroll;">

											<table  class="example-paper table3" cellspacing="0"  align="center">
												<thead>
												<tr>
													<th>工单流水号</th>
													<th>原因分类</th>
													<th>原因细分</th>
													<th>故障原因</th>
													<th>处理措施</th>
													<th>添加模板</th>
												</tr>
												</thead>
												<tbody>

												</tbody>
											</table>

										</div>
									</div>

								</div>
								<!-- /BOX -->
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<!-- BOX -->
								<div class="box border green">
									<div class="box-title">
										<h4><i class="fa fa-bar-chart-o"></i>高风险：告警与故障原因</h4>
										<div class="tools">

											<a href="javascript:;" class="collapse">
												<i class="fa fa-chevron-up"></i>
											</a>

										</div>
									</div>
									<div class="box-body">
										<div   style="height:225px;overflow:scroll;">

											<table class="example-paper table4" cellspacing="0"  align="center">
												<thead>
												<tr>
													<th>工单流水号</th>
													<th>告警标题</th>
													<th>原因分类</th>
													<th>原因细分</th>
													<th>故障原因</th>
													<th>添加模板</th>

												</tr>
												</thead>
												<tbody>

												</tbody>
											</table>

										</div>
									</div>

								</div>
								<!-- /BOX -->
							</div>
						</div>
						<!-- /BORDERED HOVER -->
					</div>
					<div class="footer-tools">
							<span class="go-top">
								<i class="fa fa-chevron-up"></i> Top
							</span>
						</div>
					</div><!-- /CONTENT-->
				<div class="separator"></div>
			</div>
		</div>
	</section>
	<!--/PAGE -->
	<!-- JAVASCRIPTS -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- JQUERY -->
	<script src="js/jquery/jquery-2.0.3.min.js"></script>
	<!-- JQUERY UI-->
	<script src="js/jquery-ui-1.10.3.custom/js/jquery-ui-1.10.3.custom.min.js"></script>
	<!-- BOOTSTRAP -->
	<script src="bootstrap-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/ajaxfileupload.js"/>
		
	<!-- DATE RANGE PICKER -->
	<script src="js/bootstrap-daterangepicker/moment.min.js"></script>
	
	<script src="js/bootstrap-daterangepicker/daterangepicker.min.js"></script>
	<!-- SLIMSCROLL -->
	<script type="text/javascript" src="js/jQuery-slimScroll-1.3.0/jquery.slimscroll.min.js"></script><script type="text/javascript" src="js/jQuery-slimScroll-1.3.0/slimScrollHorizontal.min.js"></script>
	<!-- BLOCK UI -->
	<script type="text/javascript" src="js/jQuery-BlockUI/jquery.blockUI.min.js"></script>
	<!-- TABLE CLOTH -->
	<script type="text/javascript" src="js/tablecloth/js/jquery.tablecloth.js"></script>
	<script type="text/javascript" src="js/tablecloth/js/jquery.tablesorter.min.js"></script>
	<!-- COOKIE -->
	<script type="text/javascript" src="js/jQuery-Cookie/jquery.cookie.min.js"></script>

	<script src="js/main/main.js"></script>

	<script src="js/main/table.js"></script>


	<!-- CUSTOM SCRIPT -->
	<script src="js/script.js"></script>


	<script>
		jQuery(document).ready(function() {		
			App.setPage("simple_table");  //Set current page
			App.init(); //Initialise plugins and elements
		});
	</script>
	<!-- /JAVASCRIPTS -->
</body>
</html>