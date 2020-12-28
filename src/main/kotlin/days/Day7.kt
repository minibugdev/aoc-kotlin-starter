package days

class Day7 : Day(7) {

	private val bags = transformInputToBags(inputList)

	override fun partOne(): Any {
		fun searchBag(name: String): Set<Bag> {
			val containerBags = bags.filter { bag ->
				bag.contains?.keys?.contains(Bag(name, null)) == true
			}.toSet()

			return if (containerBags.isNotEmpty()) {
				containerBags + containerBags.flatMap { searchBag(it.name) }
			} else {
				emptySet()
			}
		}

		val shinyGoldContainerBags = searchBag("shiny gold")

		return shinyGoldContainerBags.size
	}

	override fun partTwo(): Any {
		fun insideBagCount(name: String): Int {
			val bagInsides = bags.first { it.name == name }.contains

			return bagInsides?.keys?.sumBy { bag ->
				val qty = bagInsides[bag]!!
				qty + (qty * insideBagCount(bag.name))
			} ?: 0
		}

		return insideBagCount("shiny gold")
	}

	private fun transformInputToBags(inputList: List<String>): List<Bag> = inputList.map { input ->
		val (bag, insideBags) = input.split(" bags contain ")

		if (insideBags == "no other bags.") {
			Bag(bag, null)
		} else {
			val contains = mutableMapOf<Bag, Int>()
			insideBags.split(", ").forEach {
				val insideBag = it.split(" ")
				val name = "${insideBag[1]} ${insideBag[2]}"
				val qty = insideBag[0].toInt()

				contains[Bag(name, null)] = qty
			}

			Bag(bag, contains)
		}
	}

	private data class Bag(val name: String, val contains: Map<Bag, Int>?)
}
