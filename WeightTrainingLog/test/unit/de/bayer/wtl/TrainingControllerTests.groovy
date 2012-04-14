package de.bayer.wtl



import org.junit.*
import grails.test.mixin.*

@TestFor(TrainingController)
@Mock(Training)
class TrainingControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/training/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.trainingInstanceList.size() == 0
        assert model.trainingInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.trainingInstance != null
    }

    void testSave() {
        controller.save()

        assert model.trainingInstance != null
        assert view == '/training/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/training/show/1'
        assert controller.flash.message != null
        assert Training.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/training/list'


        populateValidParams(params)
        def training = new Training(params)

        assert training.save() != null

        params.id = training.id

        def model = controller.show()

        assert model.trainingInstance == training
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/training/list'


        populateValidParams(params)
        def training = new Training(params)

        assert training.save() != null

        params.id = training.id

        def model = controller.edit()

        assert model.trainingInstance == training
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/training/list'

        response.reset()


        populateValidParams(params)
        def training = new Training(params)

        assert training.save() != null

        // test invalid parameters in update
        params.id = training.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/training/edit"
        assert model.trainingInstance != null

        training.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/training/show/$training.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        training.clearErrors()

        populateValidParams(params)
        params.id = training.id
        params.version = -1
        controller.update()

        assert view == "/training/edit"
        assert model.trainingInstance != null
        assert model.trainingInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/training/list'

        response.reset()

        populateValidParams(params)
        def training = new Training(params)

        assert training.save() != null
        assert Training.count() == 1

        params.id = training.id

        controller.delete()

        assert Training.count() == 0
        assert Training.get(training.id) == null
        assert response.redirectedUrl == '/training/list'
    }
}
