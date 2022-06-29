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
        1 -> parseFormat1(instruction)
        else -> ""
    }

    println("""
        Parsed instruction(s): 
        0x${instruction.toString(16).padStart(4, '0').uppercase()}: $formattedInstruction
    """.trimIndent())
}
