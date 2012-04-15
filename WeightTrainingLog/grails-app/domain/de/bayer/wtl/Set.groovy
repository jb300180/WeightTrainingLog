package de.bayer.wtl

import groovy.transform.ToString


@ToString(includeNames = true, includeFields = true)
class Set {

	Integer order
	Exercise exercise
	int reps=10
	//	int reps=10
	BigDecimal weight

	static belongsTo = [training: Training]

	static constraints = {
		order(nullable: false)
		exercise(nullable: false)
		reps(range: 1..200)
		weight(nullable: true)
	}
}
