package de.bayer.wtl


class TrainingController {

	def scaffold = true

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def dashboard() {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[trainingInstanceList: Training.list(params), trainingInstanceTotal: Training.count()]
	}

	def create() {
		print "session user: ${session.user}"
		//		[trainingInstance: new Training(params)]
		def trainingInstance1 = new Training(params)
		// TODO do I have to attach the user here?
		trainingInstance1.user = session.user.attach()
		[trainingInstance: trainingInstance1]
	}

	def save() {
		print 'saving...'
		def trainingInstance = new Training(params)
		// TODO do I have to attach the user here?
		trainingInstance.user = session.user.attach()
		if (!trainingInstance.save(flush: true)) {
			render(view: "create", model: [trainingInstance: trainingInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'training.label', default: 'Training'),
			trainingInstance.id
		])
		redirect(action: "dashboard")
		//		redirect(action: "show", id: trainingInstance.id)
	}
}
