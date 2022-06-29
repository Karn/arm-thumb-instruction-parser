/**
 * Format 3: move/compare/add/subtract immediate
 */
object Format3 : Format {
    override fun parse(instruction: Int): String {
        val op = instruction.getBits(11, 0b11)

        val d = instruction.getBits(8, 0b111)

        val offset = instruction.getBits(0, 0b11111111)

        val opType = when (op) {
            0b00 -> "MOV"
            0b01 -> "CMP"
            0b10 -> "ADD"
            0b11 -> "SUB"
            else -> error("unreachable")
        }

        return "$opType R$d #$offset"
    }
}
