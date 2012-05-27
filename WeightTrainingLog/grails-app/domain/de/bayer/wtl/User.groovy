package de.bayer.wtl

import groovy.transform.ToString
import java.util.Set


@ToString(includeNames = true, includeFields = true, excludes="password")
class User {

	transient springSecurityService

	String username
	String password
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
	String firstName
	String lastName
	String email

	static hasMany = [trainings: Training]

	static constraints = {
		username(blank:false, size:3..20, unique: true)
		// TODO how can I make sure the password is longer than 6 bytes before it is encrypted?
		password(blank:false, size:3..20)
		firstName(blank:false, size:2..100)
		lastName(blank:false, size:2..100)
		email(email: true, nullable: true)
		enabled()
	}

	static mapping = { password column: '`password`' }

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
