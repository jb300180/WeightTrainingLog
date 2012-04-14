package de.bayer.wtl

import grails.test.mixin.*



/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
@Mock([Training, TrainingType, Set, Exercise, Gym])
class UserTests {

	def training
	def exercise
	def trainingType
	def set
	def gym

	void setUp() {
		exercise = new Exercise(name: 'bp', description: 'press the bar')
		trainingType = new TrainingType(phase: 'max power', muscleGroup: 'upper body')
		set = new Set(exercise: exercise, reps: 5, weight: new BigDecimal("100.5"))
		gym = new Gym(name: 'mc fit', city: 'mainz')
		training = new Training(date: new Date(), gym: gym, trainingType: trainingType, sets: (set))
	}

	void testNull() {
		def user = new User()
		assert !user.validate()
		assert "nullable" == user.errors["userName"].code
		assert "nullable" == user.errors["password"].code
		assert "nullable" == user.errors["firstName"].code
		assert "nullable" == user.errors["lastName"].code
	}

	void testMin() {
		def user = new User(userName: '12', password: '12345', firstName: '1', lastName: '1', email: 'invalid')
		assert !user.validate()
		assert "size.toosmall" == user.errors["userName"].code
		assert "size.toosmall" == user.errors["password"].code
		assert "size.toosmall" == user.errors["firstName"].code
		assert "size.toosmall" == user.errors["lastName"].code
		assert "email.invalid" == user.errors["email"].code
	}

	void testMax() {
		def user = new User(userName: '1', password: '1', firstName: '1', lastName: '1', email: 'invalid@wrong')
		20.times{
			user.userName=user.userName+'1'; user.password=user.password+'1'
		}
		100.times{
			user.firstName=user.firstName+'1'; user.lastName=user.lastName+'1';
		}
		assert !user.validate()
		assert "size.toobig" == user.errors["userName"].code
		assert "size.toobig" == user.errors["password"].code
		assert "size.toobig" == user.errors["firstName"].code
		assert "size.toobig" == user.errors["lastName"].code
		assert "email.invalid" == user.errors["email"].code
	}

	void testUnique() {
		def user = new User(userName: '123', password: '123456', firstName: 'Il', lastName: 'Li', email: 'li@il.li', trainings: [training])
		mockForConstraintsTests(User,[user])
		assert user.validate()
		assert user.save()

		def userDouble = new User(userName: '123', password: '123456', firstName: 'Il', lastName: 'Li', email: 'li@il.li')
		assert !userDouble.validate()
		log.info 'errors on userName: ' + userDouble.errors["userName"]
		assert "unique" == userDouble.errors["userName"]
	}

	void testSave() {
		def user = new User(userName: '123', password: '123456', firstName: 'Il', lastName: 'Li', email: 'li@il.li', trainings: [training])
		log.info "sets: ${user.trainings.sets}"
		assert user.validate()
		assert user.save()
	}
}
