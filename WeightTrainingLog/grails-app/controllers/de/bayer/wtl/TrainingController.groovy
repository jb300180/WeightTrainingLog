package de.bayer.wtl


class TrainingController {

	def scaffold = true

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def dashboard() {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[trainingInstanceList: Training.list(params), trainingInstanceTotal: Training.count()]
	}

	//	def index() {
	//		redirect(action: "list", params: params)
	//	}
	//
	//	def list() {
	//		params.max = Math.min(params.max ? params.int('max') : 10, 100)
	//		[trainingInstanceList: Training.list(params), trainingInstanceTotal: Training.count()]
	//	}
	//
	//	def create() {
	//		[trainingInstance: new Training(params)]
	//	}
	//
	//	def save() {
	//		def trainingInstance = new Training(params)
	//		if (!trainingInstance.save(flush: true)) {
	//			render(view: "create", model: [trainingInstance: trainingInstance])
	//			return
	//		}
	//
	//		flash.message = message(code: 'default.created.message', args: [
	//			message(code: 'training.label', default: 'Training'),
	//			trainingInstance.id
	//		])
	//		redirect(action: "show", id: trainingInstance.id)
	//	}
	//
	//	def show() {
	//		def trainingInstance = Training.get(params.id)
	//		if (!trainingInstance) {
	//			flash.message = message(code: 'default.not.found.message', args: [
	//				message(code: 'training.label', default: 'Training'),
	//				params.id
	//			])
	//			redirect(action: "list")
	//			return
	//		}
	//
	//		[trainingInstance: trainingInstance]
	//	}
	//
	//	def edit() {
	//		def trainingInstance = Training.get(params.id)
	//		if (!trainingInstance) {
	//			flash.message = message(code: 'default.not.found.message', args: [
	//				message(code: 'training.label', default: 'Training'),
	//				params.id
	//			])
	//			redirect(action: "list")
	//			return
	//		}
	//
	//		[trainingInstance: trainingInstance]
	//	}
	//
	//	def update() {
	//		def trainingInstance = Training.get(params.id)
	//		if (!trainingInstance) {
	//			flash.message = message(code: 'default.not.found.message', args: [
	//				message(code: 'training.label', default: 'Training'),
	//				params.id
	//			])
	//			redirect(action: "list")
	//			return
	//		}
	//
	//		if (params.version) {
	//			def version = params.version.toLong()
	//			if (trainingInstance.version > version) {
	//				trainingInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
	//						[
	//							message(code: 'training.label', default: 'Training')]
	//						as Object[],
	//						"Another user has updated this Training while you were editing")
	//				render(view: "edit", model: [trainingInstance: trainingInstance])
	//				return
	//			}
	//		}
	//
	//		trainingInstance.properties = params
	//
	//		if (!trainingInstance.save(flush: true)) {
	//			render(view: "edit", model: [trainingInstance: trainingInstance])
	//			return
	//		}
	//
	//		flash.message = message(code: 'default.updated.message', args: [
	//			message(code: 'training.label', default: 'Training'),
	//			trainingInstance.id
	//		])
	//		redirect(action: "show", id: trainingInstance.id)
	//	}
	//
	//	def delete() {
	//		def trainingInstance = Training.get(params.id)
	//		if (!trainingInstance) {
	//			flash.message = message(code: 'default.not.found.message', args: [
	//				message(code: 'training.label', default: 'Training'),
	//				params.id
	//			])
	//			redirect(action: "list")
	//			return
	//		}
	//
	//		try {
	//			trainingInstance.delete(flush: true)
	//			flash.message = message(code: 'default.deleted.message', args: [
	//				message(code: 'training.label', default: 'Training'),
	//				params.id
	//			])
	//			redirect(action: "list")
	//		}
	//		catch (DataIntegrityViolationException e) {
	//			flash.message = message(code: 'default.not.deleted.message', args: [
	//				message(code: 'training.label', default: 'Training'),
	//				params.id
	//			])
	//			redirect(action: "show", id: params.id)
	//		}
	//	}
}
