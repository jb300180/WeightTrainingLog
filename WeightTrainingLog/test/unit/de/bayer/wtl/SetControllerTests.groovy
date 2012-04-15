package de.bayer.wtl

import grails.test.mixin.Mock
import grails.test.mixin.TestFor


@TestFor(SetController)
@Mock(Set)
class SetControllerTests {


	def populateValidParams(params) {
		assert params != null
		params['order']=1
		params['exercise.name']='Bench press'
		params['exercise.description']='press the bar'
		params['reps']=3
		params['weight']=BigDecimal.TEN
		def user = new User(userName: '123', password: '123456', firstName: 'Il', lastName: 'Li', email: 'li@il.li')
		def training = new Training(date: new Date(), user: user)
		params['training'] = training
	}

	void testIndex() {
		controller.index()
		assert "/set/list" == response.redirectedUrl
	}

	void testList() {

		def model = controller.list()

		assert model.setInstanceList.size() == 0
		assert model.setInstanceTotal == 0
	}

	void testCreate() {
		def model = controller.create()

		assert model.setInstance != null
	}

	void testSave() {
		controller.save()

		assert model.setInstance != null
		assert view == '/set/create'

		response.reset()

		populateValidParams(params)
		controller.save()

		assert response.redirectedUrl == '/set/show/1'
		assert controller.flash.message != null
		assert Set.count() == 1
	}

	void testShow() {
		controller.show()

		assert flash.message != null
		assert response.redirectedUrl == '/set/list'


		populateValidParams(params)
		def set = new Set(params)

		assert set.save() != null

		params.id = set.id

		def model = controller.show()

		assert model.setInstance == set
	}

	void testEdit() {
		controller.edit()

		assert flash.message != null
		assert response.redirectedUrl == '/set/list'


		populateValidParams(params)
		def set = new Set(params)

		assert set.save() != null

		params.id = set.id

		def model = controller.edit()

		assert model.setInstance == set
	}

	void testUpdate() {
		controller.update()

		assert flash.message != null
		assert response.redirectedUrl == '/set/list'

		response.reset()


		populateValidParams(params)
		def set = new Set(params)

		assert set.save() != null

		// test invalid parameters in update
		params.id = set.id
		params['reps'] = -4
		controller.update()

		assert view == "/set/edit"
		assert model.setInstance != null

		set.clearErrors()

		populateValidParams(params)
		controller.update()

		assert response.redirectedUrl == "/set/show/$set.id"
		assert flash.message != null

		//test outdated version number
		response.reset()
		set.clearErrors()

		populateValidParams(params)
		params.id = set.id
		params.version = -1
		controller.update()

		assert view == "/set/edit"
		assert model.setInstance != null
		assert model.setInstance.errors.getFieldError('version')
		assert flash.message != null
	}

	void testDelete() {
		controller.delete()
		assert flash.message != null
		assert response.redirectedUrl == '/set/list'

		response.reset()

		populateValidParams(params)
		def set = new Set(params)

		assert set.save() != null
		assert Set.count() == 1

		params.id = set.id

		controller.delete()

		assert Set.count() == 0
		assert Set.get(set.id) == null
		assert response.redirectedUrl == '/set/list'
	}
}
