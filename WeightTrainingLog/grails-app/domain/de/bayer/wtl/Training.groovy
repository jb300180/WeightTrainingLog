package de.bayer.wtl

import groovy.transform.ToString


@ToString(includeNames = true, includeFields = true)
class Training {

	Date date
	TrainingType trainingType
	Gym gym
	int rating

	static belongsTo = [user: User]

	static hasMany = [sets: Set]
	static mapping = { sets sort: 'order' }


	static constraints = {
		date (nullable: false)
		// TODO ask koko why I need to set nullable to true
		trainingType (nullable: true) // leer, aber fuer sortierung...
		gym (nullable: true)
		rating (range: 0..5)
	}
}
