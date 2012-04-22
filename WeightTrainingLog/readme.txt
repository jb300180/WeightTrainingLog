#I had to "downgrade" to Grails 2.0.1 and Java 1.6 to get this running on Cloudfoundry
#I had to "downgrade" to Grails 2.0.1 and Java 1.6 to get this running on Cloudfoundry
#I had to "downgrade" to Grails 2.0.1 and Java 1.6 to get this running on Cloudfoundry
#I had to "downgrade" to Grails 2.0.1 and Java 1.6 to get this running on Cloudfoundry

#I'm using the following plugins:

install-plugin cloud-foundry
install-plugin :jquery-datatables:1.7.5
install-plugin :jquery-ui:1.8.15 
install-plugin :jquery-mobile:1.0.4
install-plugin acegi

#security:
install-plugin acegi
create-auth-domains DummyUser de.bayer.wtl.Role de.bayer.wtl.Requestmap
#
# you may have to compile/refresh dependencies (ALT+G, R) for sts...
#
# "DummyUser", as we already have a "User" class
# in our case we have to add these constraints to the user class:
# 	static hasMany = [ authorities: com.grailsinaction.Role, ... ]
# 	static belongsTo = com.grailsinaction.Role
# than make role point to user instead of dummy user
# if admin is created in bootstrap you may want to encode pwd:
# 	authenticateService.encodePassword("password")
# go to SecurityConfig and change User class... and well, do more customizing ;)

# of course you have to configure bootstrap accordingly

# further information on customizing security is available here:
# http://www.grails.org/AcegiSecurity+Plugin+-+Customizing+with+SecurityConfig