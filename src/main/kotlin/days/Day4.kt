package days

class Day4 : Day(4) {

	private val requiredFields = arrayOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
	private val passports = inputList.joinToString(" ").split("  ").map { input ->
		val passport = mutableMapOf<String, String>()
		input.split(" ").forEach { data ->
			val (k, v) = data.split(":")
			passport[k] = v
		}
		passport
	}

	override fun partOne(): Any {
		return passports.count { passport -> requiredFields.all { it in passport.keys } }
	}

	override fun partTwo(): Any {
		val byrRule = 1920..2002
		val iyrRule = 2010..2020
		val eyrRule = 2020..2030
		val hgtCmRule = 150..193
		val hgtInRule = 59..76
		val hclRule = "^#([a-fA-F0-9]{6}|[a-fA-F0-9]{3})\$"
		val eclRule = arrayOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
		val pidRule = 9

		return passports.count { passport ->
			val validators = mutableListOf<Boolean>()

			val byrValid = passport["byr"]?.toInt() in byrRule
			validators.add(byrValid)

			val iyrValid = passport["iyr"]?.toInt() in iyrRule
			validators.add(iyrValid)

			val eyrValid = passport["eyr"]?.toInt() in eyrRule
			validators.add(eyrValid)

			val hgtValid = when (passport["hgt"]?.takeLast(2)?.toLowerCase()) {
				"cm" -> passport["hgt"]!!.dropLast(2).toInt() in hgtCmRule
				"in" -> passport["hgt"]!!.dropLast(2).toInt() in hgtInRule
				else -> false
			}
			validators.add(hgtValid)

			val hclValid = passport["hcl"]?.matches(Regex(hclRule)) ?: false
			validators.add(hclValid)

			val eclValid = eclRule.contains(passport["ecl"])
			validators.add(eclValid)

			val pidValid = passport["pid"]?.length == pidRule
			validators.add(pidValid)

			validators.all { it }
		}
	}
}
