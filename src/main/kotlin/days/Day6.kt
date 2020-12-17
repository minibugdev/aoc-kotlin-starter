package days

class Day6 : Day(6) {

	override fun partOne(): Any {
		val answerGroups = inputList.joinToString("#")
			.split("##")
			.map { it.replace("#", "").toSet() }

		return answerGroups.sumBy { it.size }
	}

	override fun partTwo(): Any {
		val answerGroups = inputList.joinToString("#")
			.split("##")
			.map { it.split("#") }

		return answerGroups.sumBy { answerGroup ->
			val peopleInGroup = answerGroup.size

			if (peopleInGroup == 1) {
				answerGroup[0].length
			} else {
				answerGroup.flatMap { it.toList() }
					.groupBy { it }
					.count { it.value.size == peopleInGroup }
			}
		}
	}
}
