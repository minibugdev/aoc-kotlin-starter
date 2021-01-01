package days

class Day9 : Day(9) {

	private val numbers = inputList.map { it.toLong() }

	override fun partOne(): Any {
		val preambleSize = 25

		return numbers.windowed(preambleSize + 1, 1) {
			val target = it.last()
			val previousNumbers = it.dropLast(1).toSet()

			val isPreambleValid = previousNumbers.any { n -> target - n in previousNumbers }
			if (isPreambleValid) {
				null
			} else {
				target
			}
		}.first { it != null }!!
	}

	override fun partTwo(): Any {
		val invalidNumber = partOne() as Long
		var results = listOf<Long>()
		var i = 2

		while (results.isEmpty()) {
			results = numbers.windowed(i++, 1)
				.firstOrNull {
					it.sum() == invalidNumber
				}
				?: emptyList()
		}

		val max = results.maxOrNull() ?: 0L
		val min = results.minOrNull() ?: 0L
		return max + min
	}
}
