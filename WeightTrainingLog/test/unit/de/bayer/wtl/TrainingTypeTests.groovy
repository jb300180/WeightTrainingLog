package de.bayer.wtl

import grails.test.mixin.TestFor


/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(TrainingType)
class TrainingTypeTests {

	void testNull() {
		def trainingType=new TrainingType()
		assert trainingType.validate()
		assert trainingType.save()
	}

	void testMin() {
		def trainingType=new TrainingType(phase:"a", muscleGroup: 'a')
		assert !trainingType.validate()
		assert "size.toosmall" == trainingType.errors["phase"].code
		assert "size.toosmall" == trainingType.errors["muscleGroup"].code
	}

	void testMax() {
		def trainingType=new TrainingType(phase:"a", muscleGroup: 'a')
		50.times{trainingType.phase=trainingType.phase+"a"; trainingType.muscleGroup=trainingType.muscleGroup+"a"}
		assert !trainingType.validate()
		assert "size.toobig" == trainingType.errors["phase"].code
		assert "size.toobig" == trainingType.errors["muscleGroup"].code
	}

	void testSave() {
		def trainingType=new TrainingType(phase:"max power", muscleGroup: 'chest')
		assert trainingType.validate()
		assert trainingType.save()
	}
	void testSomething() {
	}
}
