<!doctype html>
<html>
<head>
<meta name="layout" content="main" />
<title>Welcome to <g:meta name="app.name" /></title>
</head>
<body>
	<div id="page-body" role="main">
		<h1>Welcome to Grails</h1>
		<p>Congratulations, you have successfully started your first
			Grails application! At the moment this is the default page, feel free
			to modify it to either redirect to a controller or display whatever
			content you may choose. Below is a list of controllers that are
			currently deployed in this application, click on each to execute its
			default action:</p>

		<div id="content">
			<h2>quick links&hellip;</h2>
			<ul>
				<li><g:link controller="user" action="login">login</g:link>
				<li><g:link controller="training" action="dashboard">Dashboard</g:link>
				</li>
			</ul>
		</div>
		
		<div id="controller-list" role="navigation">
			<h2>Available Controllers:</h2>
			<ul>
				<g:each var="c"
					in="${grailsApplication.controllerClasses.sort { it.fullName } }">
					<li class="controller"><g:link
							controller="${c.logicalPropertyName}">
							${c.fullName}
						</g:link></li>
				</g:each>
			</ul>
		</div>
		
	</div>
</body>
</html>
