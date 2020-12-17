package days

class Day5 : Day(5) {

	private val seatIds: List<Int> = inputList.map { bp ->
		val row = bp.take(7).fold((0..127).toList()) { acc, direction ->
			val half = acc.count() / 2
			when (direction) {
				'F' -> acc.take(half)
				else -> acc.drop(half)
			}
		}.first()

		val col = bp.drop(7).fold((0..7).toList()) { acc, direction ->
			val half = acc.count() / 2
			when (direction) {
				'L' -> acc.take(half)
				else -> acc.drop(half)
			}
		}.first()

		row * 8 + col
	}.sorted()

	override fun partOne(): Any {
		return seatIds.last()
	}

	override fun partTwo(): Any {
		val min = seatIds.first()
		val max = seatIds.last()

		return (min..max).subtract(seatIds).first()
	}
}
