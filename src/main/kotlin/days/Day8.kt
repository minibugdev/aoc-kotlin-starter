package days

import java.lang.IllegalArgumentException

class Day8 : Day(8) {

	private val instructions = inputList.mapIndexed { index, input ->
		val (operation, argument) = input.split(" ")
		Operation(index, operation, argument.toInt())
	}

	private val instructionStack = mutableListOf<Int>()

	private fun execute(index: Int, instructions: List<Operation>): Int {
		val accumulator: Int
		val operation = instructions[index]
		instructionStack.add(index)

		val nextIndex = when (operation.operation) {
			"nop" -> {
				accumulator = 0
				index + 1
			}
			"jmp" -> {
				accumulator = 0
				index + operation.argument
			}
			"acc" -> {
				accumulator = operation.argument
				index + 1
			}
			else -> throw IllegalArgumentException("The ${operation.operation} operation doesn't support.")
		}

		return when {
			// Terminate
			nextIndex > instructions.lastIndex -> accumulator

			// Terminate when infinite Loop
			nextIndex in instructionStack -> accumulator

			// Execute next
			else -> accumulator + execute(nextIndex, instructions)
		}
	}

	override fun partOne(): Any {
		return execute(0, instructions)
	}

	override fun partTwo(): Any {
		var accumulator = 0
		var processing = true

		val lastInstructionIndex = instructions.lastIndex
		val jmpInstructions = instructions.filter { it.operation == "jmp" }.toMutableList()
		val nopInstructions = instructions.filter { it.operation == "nop" }.toMutableList()

		while (processing) {
			instructionStack.clear()

			if (nopInstructions.isNotEmpty() || jmpInstructions.isNotEmpty()) {
				val operation: Operation

				if (nopInstructions.isNotEmpty()) {
					operation = nopInstructions.last().copy(operation = "jmp")
					nopInstructions.removeLast()
				} else {
					operation = jmpInstructions.last().copy(operation = "nop")
					jmpInstructions.removeLast()
				}

				val fixInstructions = instructions.toMutableList()
				fixInstructions[operation.index] = operation

				accumulator = execute(0, fixInstructions)
				processing = instructionStack.lastOrNull() != lastInstructionIndex
			} else {
				processing = false
			}
		}

		return accumulator
	}

	data class Operation(val index: Int, val operation: String, val argument: Int)
}
