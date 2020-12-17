package days

class Day3 : Day(3) {

	override fun partOne(): Any {
		return countingTree(3, 1)
	}

	override fun partTwo(): Any {
		return arrayOf(
			countingTree(1, 1),
			countingTree(3, 1),
			countingTree(5, 1),
			countingTree(7, 1),
			countingTree(1, 2),
		).fold(1L) { acc, elem -> acc * elem }
	}

	private fun countingTree(right: Int, down: Int): Int {
		var count = 0
		var column = 1
		for (row in down until inputList.size step down) {
			val encounterAt = (column++ * right) % inputList[row].count()

			val isTree = inputList[row][encounterAt] == '#'
			if (isTree) {
				count += 1
			}
		}

		return count
	}
}
