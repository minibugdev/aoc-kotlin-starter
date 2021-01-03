package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day10Test {

	private val aoc = Day10()

	@Test
	fun testPartOne() {
		assertThat(aoc.partOne(), `is`(22))
	}

	@Test
	fun testPartTwo() {
		val partTwo = aoc.partTwo()
		assertThat(partTwo, `is`(Unit))
	}
}
