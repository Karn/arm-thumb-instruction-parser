fun main(args: Array<String>) {
    // Parse an incoming HEX string into the corresponding THUMB Instruction
    // Ref: http://bear.ces.cwru.edu/eecs_382/ARM7-TDMI-manual-pt3.pdf
    require(args.isNotEmpty()) {
        "program requires at least one 32-bit hex instruction"
    }
    val instructions = args[0].takeIf { it.length % 2 == 0 }
        ?.chunked(4)
    require(instructions != null) {
        "unable to parse instructions -- invalid size"
    }


    val result = instructions.map { hexInstruction ->
        val instruction = try {
            Integer.parseInt(hexInstruction, 16)
        } catch (ex: NumberFormatException) {
            error("unable to convert arg to hex -- $hexInstruction")
        }

        val format = parseThumbInstructionFormat(instruction)
        val formattedInstruction = when (format) {
            1 -> Format1.parse(instruction)
            2 -> Format2.parse(instruction)
            3 -> Format3.parse(instruction)
            4 -> Format4.parse(instruction)
            5 -> Format5.parse(instruction)
            6 -> Format6.parse(instruction)
            7 -> Format7.parse(instruction)
            8 -> Format8.parse(instruction)
            9 -> Format9.parse(instruction)
            10 -> Format10.parse(instruction)
            11 -> Format11.parse(instruction)
            12 -> Format12.parse(instruction)
            13 -> Format13.parse(instruction)
            14 -> Format14.parse(instruction)
            15 -> Format15.parse(instruction)
            16 -> Format16.parse(instruction)
            17 -> Format17.parse(instruction)
            18 -> Format18.parse(instruction)
            19 -> Format19.parse(instruction)
            else -> error("unreachable")
        }

        instruction to formattedInstruction
    }


    println(
        """
        Parsed instruction(s):
        ${
            result.joinToString("\n") { (instruction, formattedInstruction) ->
                "0x${instruction.toString(16).padStart(4, '0').uppercase()}    $formattedInstruction"
            }
        }
    """.trimIndent()
    )
}
