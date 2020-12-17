package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day3Test {

	private val aoc = Day3()

	@Test
	fun testPartOne() {
		assertThat(aoc.partOne(), `is`(7))
	}

	@Test
	fun testPartTwo() {
		val partTwo = aoc.partTwo()
		assertThat(partTwo, `is`(336L))
	}
}
