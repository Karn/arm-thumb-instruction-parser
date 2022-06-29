fun main() {
    // Parse an incoming HEX string into the corresponding THUMB Instruction
    // Ref: http://bear.ces.cwru.edu/eecs_382/ARM7-TDMI-manual-pt3.pdf
    val arg = "E1FE"

    val instruction = try {
        Integer.parseInt(arg, 16)
    } catch (ex: NumberFormatException) {
        error("unable to convert arg to hex -- $arg")
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
        else -> ""
    }

    println(
        """
        Parsed instruction(s): 
        0x${instruction.toString(16).padStart(4, '0').uppercase()}: $formattedInstruction
    """.trimIndent()
    )
}
