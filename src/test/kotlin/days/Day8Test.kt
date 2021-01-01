package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day8Test {

	private val aoc = Day8()

	@Test
	fun testPartOne() {
		assertThat(aoc.partOne(), `is`(5))
	}

	@Test
	fun testPartTwo() {
		val partTwo = aoc.partTwo()
		assertThat(partTwo, `is`(8))
	}
}
