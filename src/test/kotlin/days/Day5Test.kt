package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day5Test {

	private val aoc = Day5()

	@Test
	fun testPartOne() {
		assertThat(aoc.partOne(), `is`(820))
	}

	@Test
	fun testPartTwo() {
		val partTwo = aoc.partTwo()
		assertThat(partTwo, `is`(120))
	}
}
