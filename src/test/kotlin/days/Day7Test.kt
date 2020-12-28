package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day7Test {

	private val aoc = Day7()

	@Test
	fun testPartOne() {
		assertThat(aoc.partOne(), `is`(370))
	}

	@Test
	fun testPartTwo() {
		val partTwo = aoc.partTwo()
		assertThat(partTwo, `is`(29547))
	}
}
