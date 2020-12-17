package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day4Test {

	private val aoc = Day4()

	@Test
	fun testPartOne() {
		assertThat(aoc.partOne(), `is`(208))
	}

	@Test
	fun testPartTwo() {
		val partTwo = aoc.partTwo()
		assertThat(partTwo, `is`(167))
	}
}
