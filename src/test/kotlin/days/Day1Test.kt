package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day1Test {

	private val aoc = Day1()

	@Test
	fun testPartOne() {
		assertThat(aoc.partOne(), `is`(514579))
	}

	@Test
	fun testPartTwo() {
		val partTwo = aoc.partTwo()
		assertThat(partTwo, `is`(241861950))
	}
}
