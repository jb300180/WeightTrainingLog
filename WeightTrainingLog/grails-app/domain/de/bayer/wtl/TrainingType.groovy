package de.bayer.wtl

import groovy.transform.ToString

@ToString(includeNames = true, includeFields = true)
class TrainingType {

	String phase
	String muscleGroup

	static constraints = {
		phase(nullable: true, size: 2..50)
		muscleGroup(nullable: true, size: 2..50)
	}
}
