package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day0Test {

	private val aoc = Day0()

	@Test
	fun testPartOne() {
		assertThat(aoc.partOne(), `is`(Unit))
	}

	@Test
	fun testPartTwo() {
		val partTwo = aoc.partTwo()
		assertThat(partTwo, `is`(Unit))
	}
}
