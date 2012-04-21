import de.bayer.wtl.Role
import de.bayer.wtl.User



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
		if (!User.findByUserName("admin")) {
			println '"admin" not in database. creating one...'
			//			def password = "aPassword"
			def password = authenticateService.encodePassword("aPassword")
			def user = new User(userName: "admin", enabled: true,
					password: password, firstName: "Jens", lastName: "Bayer")
			if (!user.validate()) {
				log.error "user validation failed! ${user.errors}"
				println user.errors
			}
			else
				user.save(flush:true)
			// TODO I'm still wondering how to get logging to work
			log.info "user saved - id is: ${user.id}"
			println "user saved - id is: ${user.id}"

			def ROLE_NAME="ROLE_ADMIN"
			def role=Role.findByAuthority(ROLE_NAME)
			if (!role) {
				println "${ROLE_NAME} not in database. creating one..."
				role = new Role(authority: ROLE_NAME, description: "this is the role for admins", people: [user])
				role.addToPeople(user)
				if(!role.validate())
					println role.errors
				if (!role.save(flush: true))
					println "save failed!!!"
				else
					println "saved w/id ${role}"
			}
			else
				println "role already existing"
			// TODO add user to existing role

		} else {
			println '"admin" is already in databse.'
		}

		println "reloaded user: ${User.findByUserName('admin').password}"
	}
}
