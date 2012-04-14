package de.bayer.wtl

import org.springframework.dao.DataIntegrityViolationException

class SetController {

	def scaffold = true

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}

	def list() {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[setInstanceList: Set.list(params), setInstanceTotal: Set.count()]
	}

	def create() {
		[setInstance: new Set(params)]
	}

	def save() {
		def setInstance = new Set(params)
		if (!setInstance.save(flush: true)) {
			render(view: "create", model: [setInstance: setInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'set.label', default: 'Set'),
			setInstance.id
		])
		redirect(action: "show", id: setInstance.id)
	}

	def show() {
		def setInstance = Set.get(params.id)
		if (!setInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'set.label', default: 'Set'),
				params.id
			])
			redirect(action: "list")
			return
		}

		[setInstance: setInstance]
	}

	def edit() {
		def setInstance = Set.get(params.id)
		if (!setInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'set.label', default: 'Set'),
				params.id
			])
			redirect(action: "list")
			return
		}

		[setInstance: setInstance]
	}

	def update() {
		def setInstance = Set.get(params.id)
		if (!setInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'set.label', default: 'Set'),
				params.id
			])
			redirect(action: "list")
			return
		}

		if (params.version) {
			def version = params.version.toLong()
			if (setInstance.version > version) {
				setInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						[
							message(code: 'set.label', default: 'Set')]
						as Object[],
						"Another user has updated this Set while you were editing")
				render(view: "edit", model: [setInstance: setInstance])
				return
			}
		}

		setInstance.properties = params

		if (!setInstance.save(flush: true)) {
			render(view: "edit", model: [setInstance: setInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [
			message(code: 'set.label', default: 'Set'),
			setInstance.id
		])
		redirect(action: "show", id: setInstance.id)
	}

	def delete() {
		def setInstance = Set.get(params.id)
		if (!setInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'set.label', default: 'Set'),
				params.id
			])
			redirect(action: "list")
			return
		}

		try {
			setInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [
				message(code: 'set.label', default: 'Set'),
				params.id
			])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [
				message(code: 'set.label', default: 'Set'),
				params.id
			])
			redirect(action: "show", id: params.id)
		}
	}
}
