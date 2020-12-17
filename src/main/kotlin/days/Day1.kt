package days

class Day1 : Day(1) {

	override fun partOne(): Any {
		val map = mutableMapOf<Int, Int>()
		val numbers = inputList.map { it.toInt() }
		for (n in numbers) {
			val complement = 2020 - n
			if (map.containsKey(complement)) {
				return map[complement]!! * n
			}

			map[n] = n
		}

		throw Exception("No result")
	}

	override fun partTwo(): Any {
		val numbers = inputList.map { it.toInt() }
		val size = numbers.size

		for (i in 0 until size - 2) {
			for (j in i until size - 1) {
				for (k in j until size) {
					val a = numbers[i]
					val b = numbers[j]
					val c = numbers[k]

					if (a + b + c == 2020) {
						return a * b * c
					}
				}
			}
		}

		throw Exception("No result")
	}
}
