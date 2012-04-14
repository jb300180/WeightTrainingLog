package de.bayer.wtl

import grails.test.mixin.TestFor

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Gym)
class GymTests {

	void testNull() {
		def gym=new Gym()
		assert gym.validate()
		assert gym.save()
	}

	void testMin() {
		def gym=new Gym(name:"a", city: 'a')
		assert !gym.validate()
		assert "size.toosmall" == gym.errors["name"].code
		assert "size.toosmall" == gym.errors["city"].code
	}

	void testMax() {
		def gym=new Gym(name:"a", city: 'a')
		50.times{gym.name=gym.name+"a"; gym.city=gym.city+"a"}
		assert !gym.validate()
		assert "size.toobig" == gym.errors["name"].code
		assert "size.toobig" == gym.errors["city"].code
	}

	void testSave() {
		def gym=new Gym(name:"mc fit", city: 'mainz')
		assert gym.validate()
		assert gym.save()
	}
}
