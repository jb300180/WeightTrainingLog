package de.bayer.wtl

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Training)
@Mock([TrainingType, Set, Exercise, Gym])
class TrainingTests {

	def exercise
	def trainingType
	def set
	def gym
	def user

	void setUp() {
		exercise = new Exercise(name: 'bp', description: 'press the bar')
		trainingType = new TrainingType(phase: 'max power', muscleGroup: 'upper body')
		set = new Set(exercise: exercise, reps: 5, weight: new BigDecimal("100.5"))
		gym = new Gym(name: 'mc fit', city: 'mainz')
		user = new User(userName: '123', password: '123456', firstName: 'Il', lastName: 'Li', email: 'li@il.li')
	}

	void testNull() {
		def training = new Training()
		assert !training.validate()
		assert "nullable" == training.errors["date"].code
		assert "nullable" == training.errors["user"].code
		assert !training.errors["trainingType"]
		assert !training.errors["gym"]
		assert !training.errors["rating"]
		assert !training.errors["sets"]
	}

	void testMin() {
		def training = new Training(rating: -2)
		assert !training.validate()
		assert !training.errors["range.toosmall"]
	}

	void testMax() {
		def training = new Training(rating: 7)
		assert !training.validate()
		assert !training.errors["range.toobig"]
	}

	void testSave() {
		def training = new Training(date: new Date(), gym: gym, trainingType: trainingType, sets: (set), user: user)
		assert training.sets
		assert training.validate()
		assert training.save()
	}
}
