package days

class Day2 : Day(2) {

	private val policies = inputList.map(::Policy)

	override fun partOne(): Any {
		return policies
			.count { policy ->
				val letterCount = policy.password.count { it.toString() == policy.letter }
				letterCount in policy.min..policy.max
			}
	}

	override fun partTwo(): Any {
		return policies
			.count { policy ->
				val firstValid = policy.password[policy.min - 1].toString() == policy.letter
				val secondValid = policy.password[policy.max - 1].toString() == policy.letter

				firstValid xor secondValid
			}
	}

	inner class Policy(input: String) {
		private val parts = input.split(": ")
		private val policy = parts[0].split(" ")
		private val limit = policy[0].split("-")

		val password = parts[1]
		val min = limit[0].toInt()
		val max = limit[1].toInt()
		val letter = policy[1]
	}
}
