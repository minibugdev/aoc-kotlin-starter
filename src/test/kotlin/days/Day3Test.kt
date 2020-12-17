package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class Day3Test {

	private val dayTree = Day3()

	@Test
	fun testPartOne() {
		assertThat(dayTree.partOne(), `is`(7))
	}

	@Test
	fun testPartTwo() {
		val partTwo = dayTree.partTwo()
		assertThat(partTwo, `is`(336))
	}
}
