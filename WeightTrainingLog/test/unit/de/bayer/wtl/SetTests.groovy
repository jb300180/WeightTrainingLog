package de.bayer.wtl

import grails.test.mixin.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Set)
@Mock(Exercise)
class SetTests {

	def exercise
	def trainingType
	def set
	def gym
	def user
	def training

	void setUp() {
		exercise = new Exercise(name: 'bp', description: 'press the bar')
		trainingType = new TrainingType(phase: 'max power', muscleGroup: 'upper body')
		set = new Set(exercise: exercise, reps: 5, weight: new BigDecimal("100.5"))
		gym = new Gym(name: 'mc fit', city: 'mainz')
		user = new User(userName: '123', password: '123456', firstName: 'Il', lastName: 'Li', email: 'li@il.li')
		training = new Training(date: new Date(), gym: gym, trainingType: trainingType, sets: (set), user: user)
	}

	void testNull() {
		def set = new Set()

		assert !set.validate()
		log.info 'ordering errors: ' + set.errors["ordering"]
		log.info "ordering ${set.ordering}"
		assert "nullable" == set.errors["ordering"].code
		assert "nullable" == set.errors["exercise"].code
		assert "nullable" == set.errors["training"].code
		assert "range.toosmall" == set.errors["reps"].code
	}

	void testMin() {
		def set = new Set(ordering: 1, exercise: exercise, reps: -1)
		assert !set.validate()
		assert null == set.errors["exercise"]
		assert "range.toosmall" == set.errors["reps"].code
	}

	void testMax() {
		def set = new Set(ordering: 1, exercise: exercise, reps: 206)
		assert !set.validate()
		log.info set.errors["reps"].code
		assert !set.errors["exercise"]
		assert "range.toobig" == set.errors["reps"].code
	}

	void testSave() {
		def set = new Set(ordering: 1, exercise: exercise, reps: 2, weight: new BigDecimal("65.4"), training: training)
		log.info "errors ${set.errors}"
		assert set.validate()
		assert set.save()
	}
}
