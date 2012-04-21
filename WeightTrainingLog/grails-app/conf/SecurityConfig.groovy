security {

	// see DefaultSecurityConfig.groovy for all settable/overridable properties

	active = true
	cacheUsers = false // don't use hibernate cache

	loginUserDomainClass = "de.bayer.wtl.User"
	authorityDomainClass = "de.bayer.wtl.Role"
	requestMapClass = "de.bayer.wtl.Requestmap"

	defaultTargetUrl = "/training/dashboard" // page to display after login
	useRequestMapDomainClass = false // disable dynamic rules

	userName = "userName" // default: username
	password = "password" // default: passwd

	requestMapString = """\
CONVERT_URL_TO_LOWERCASE_BEFORE_COMPARISON
PATTERN_TYPE_APACHE_ANT
/=IS_AUTHENTICATED_ANONYMOUSLY
/login/auth=IS_AUTHENTICATED_ANONYMOUSLY
/js/**=IS_AUTHENTICATED_ANONYMOUSLY
/css/**=IS_AUTHENTICATED_ANONYMOUSLY
/images/**=IS_AUTHENTICATED_ANONYMOUSLY
/plugins/**=IS_AUTHENTICATED_ANONYMOUSLY
/**=IS_AUTHENTICATED_REMEMBERED
"""
}
