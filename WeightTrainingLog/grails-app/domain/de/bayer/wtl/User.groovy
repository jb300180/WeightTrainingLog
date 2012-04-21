package de.bayer.wtl

import groovy.transform.ToString

@ToString(includeNames = true, includeFields = true, excludes="password")
class User {

	String userName
	String password
	String firstName
	String lastName
	String email
	boolean enabled

	static hasMany = [trainings: Training,authorities: Role]
	static mapping = { trainings sort: 'date', order: 'desc' }
	static belongsTo = Role

	static constraints = {
		userName(blank:false, size:3..20, unique: true)
		// TODO how can I make sure the password is longer than 6 bytes before it is encrypted?
		password(blank:false, size:6..40)
		firstName(blank:false, size:2..100)
		lastName(blank:false, size:2..100)
		email(email: true, nullable: true)
		enabled()
	}
}
