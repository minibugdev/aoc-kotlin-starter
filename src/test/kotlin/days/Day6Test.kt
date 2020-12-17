package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day6Test {

	private val aoc = Day6()

	@Test
	fun testPartOne() {
		assertThat(aoc.partOne(), `is`(11))
	}

	@Test
	fun testPartTwo() {
		val partTwo = aoc.partTwo()
		assertThat(partTwo, `is`(6))
	}
}
