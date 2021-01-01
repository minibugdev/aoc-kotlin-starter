package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day9Test {

	private val aoc = Day9()

	@Test
	fun testPartOne() {
		assertThat(aoc.partOne(), `is`(15690279L))
	}

	@Test
	fun testPartTwo() {
		val partTwo = aoc.partTwo()
		assertThat(partTwo, `is`(2174232L))
	}
}
