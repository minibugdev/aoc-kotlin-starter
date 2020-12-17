package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day2Test {

	private val aoc = Day2()

	@Test
	fun testPartOne() {
		assertThat(aoc.partOne(), `is`(2))
	}

	@Test
	fun testPartTwo() {
		val partTwo = aoc.partTwo()
		assertThat(partTwo, `is`(1))
	}
}
