package de.bayer.wtl

import groovy.transform.ToString

@ToString(includeNames = true, includeFields = true, excludes="password")
class User {

	String userName
	String password
	String firstName
	String lastName
	String email

	static hasMany = [trainings: Training]
	static mapping = { trainings sort: 'date', order: 'desc' }

	static constraints = {
		userName(blank:false, size:3..20, unique: true)
		password(blank:false, size:6..20)
		firstName(blank:false, size:2..100)
		lastName(blank:false, size:2..100)
		email(email: true, nullable: true)
	}
}
