package de.bayer.wtl

import static org.junit.Assert.*

import org.junit.*

class UserIntegrationTests extends GroovyTestCase{

	def training
	def exercise
	def trainingType
	def set
	def gym

	@Before
	void setUp() {
		exercise = new Exercise(name: 'bp', description: 'press the bar')
		trainingType = new TrainingType(phase: 'max power', muscleGroup: 'upper body')
		set = new Set(exercise: exercise, reps: 5, weight: new BigDecimal("100.5"))
		gym = new Gym(name: 'mc fit', city: 'mainz')
		training = new Training(date: new Date(), gym: gym, trainingType: trainingType, sets: (set))
	}


	@Test
	void testSomething() {
		def user = new User(userName: '123', password: '123456', firstName: 'Kim', lastName: 'It-Serv', email: 'li@il.li', trainings: [training])
		assert user.validate()
		log.info user.errors
		assert user.save()


		training.user=user
		training.save(flush: true)
		user.save(flush: true)

		// TODO why is this not working?
		log.info training.findAll()
		log.info user.findAll()

		assert 1 == training.findAll().size()
		user.delete(flush: true)
		log.info training.findAll().size()
		assert 0 == training.findAll().size()
	}
}
