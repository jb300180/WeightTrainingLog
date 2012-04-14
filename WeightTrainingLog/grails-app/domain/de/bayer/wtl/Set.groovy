package de.bayer.wtl

import groovy.transform.ToString


@ToString(includeNames = true, includeFields = true)
class Set {

	Integer ordering
	Exercise exercise
	int reps
	BigDecimal weight

	static belongsTo = [training: Training]

	static constraints = {
		ordering(nullable: false)
		exercise(nullable: false)
		reps(range: 1..200)
		weight(nullable: true)
	}
}
