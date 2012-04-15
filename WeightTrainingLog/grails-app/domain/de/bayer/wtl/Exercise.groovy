package de.bayer.wtl


//@ToString(includeNames = true, includeFields = true)
class Exercise {

	String name
	String description

	static constraints = {
		name(blank: false, size:2..50)
		description(blank:false, size:2..1000)
	}

	def String toString() {
		name
	}
}
