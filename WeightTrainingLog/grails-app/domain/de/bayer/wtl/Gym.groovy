package de.bayer.wtl

import groovy.transform.ToString

@ToString(includeNames = true, includeFields = true)
class Gym {

	String name
	String city

	static constraints = {
		name(nullable: true, size: 2..50)
		city(nullable: true, size: 2..50)
	}
}
