<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title><g:layoutTitle default="Grails" /></title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="shortcut icon"
		href="${resource(dir: 'images', file: 'favicon.ico')}"
		type="image/x-icon">
	<g:javascript library="jquery" />
	<jqDT:resources />
	<r:require modules="jquery-mobile" />
	<g:layoutHead />
	<r:layoutResources />
</head>
<body>

	<div data-role="page" data-theme="b">

		<div data-role="header">
			<div align="right">
				<g:loggedInUserInfo field="userName">Guest</g:loggedInUserInfo>
				<g:isLoggedIn>
					<g:link controller="logout" action="index">sign out</g:link>
				</g:isLoggedIn>
			</div>
			
			<div data-role="navbar">
				<ul>
					<li> <g:link controller="training" action="dashboard">Dashboard</g:link> </li>
					<li> <g:link controller="gym">Gym</g:link> </li>
					<li> <g:link controller="trainingType">Training Type</g:link> </li>
					<li> <g:link controller="exercise">Exercise</g:link> </li>
				</ul>
			</div> <!-- navbar -->

		<div> <!-- header -->

		<div data-role="content">
			<g:layoutBody />
		</div>

		<div data-role="footer">
			<g:meta name="app.name" />
			<g:meta name="app.version" />
			<p style="font-size: x-small;">You can change the version of your
				application at any time by using the grails setversion command from
				the command line, or by editing the application.properties file
				directly.</p>
		</div><!-- footer -->
		
	</div><!-- page -->

	<g:javascript library="application" />
	<r:layoutResources />

</body>
</html>