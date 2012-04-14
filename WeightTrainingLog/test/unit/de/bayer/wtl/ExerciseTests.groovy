package de.bayer.wtl

import grails.test.mixin.TestFor


/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Exercise)
class ExerciseTests {

	void testNull() {
		def exercise = new Exercise()

		assert !exercise.validate()
		assert "nullable" == exercise.errors["name"].code
		assert "nullable" == exercise.errors["description"].code
	}

	void testTooSmall() {
		def exercise = new Exercise(name:"a", description: "a")

		assert !exercise.validate()
		assert "size.toosmall" == exercise.errors["name"].code
		assert "size.toosmall" == exercise.errors["description"].code
	}

	void testTooBig() {
		def exercise = new Exercise(name:"name", description: "desc")
		50.times {
			exercise.name = exercise.name + "a"
		}
		1000.times {
			exercise.description = exercise.description + "a"
		}
		assert !exercise.validate()
		assert "size.toobig" == exercise.errors["name"].code
		assert "size.toobig" == exercise.errors["description"].code
	}

	void testSave() {
		def exercise = new Exercise(name:"name", description: "desc")

		assert exercise.validate()
		assert exercise.save()
	}
}
