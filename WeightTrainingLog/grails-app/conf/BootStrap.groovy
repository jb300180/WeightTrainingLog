import de.bayer.wtl.User

class BootStrap {

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
			def user = new User(userName: "admin",
					password: "0415-wtl", firstName: "Jens", lastName: "Bayer").save()
		} else {
			println '"admin" is already in databse.'
		}
	}
}
