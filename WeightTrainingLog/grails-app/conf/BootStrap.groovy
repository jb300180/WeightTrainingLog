import de.bayer.wtl.Role
import de.bayer.wtl.User
import de.bayer.wtl.UserRole



class BootStrap {

	def authenticateService

	def init = { servletContext ->
		//		switch (Environment.current) {
		//			case Environment.DEVELOPMENT:
		createAdmin()
		//				break;
		//	}
	}

	def destroy = {
	}

	void createAdmin() {
		def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
		def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

		def testUser = new User(
				username: 'admin123',
				enabled: true,
				password: 'admin321',
				firstName: 'Jens',
				lastName: 'Bayer',
				email: 'jb@gmail.com'
				)
		if (!testUser.validate())
			println testUser.errors
		assert testUser.save(flush: true)
		//		testUser.save()

		UserRole.create testUser, adminRole, true

		assert User.count() >= 1
		assert Role.count() >= 2
		assert UserRole.count() >= 1
	}
}
