/**
 * Format 7: load/store with register offset
 */
object Format7 : Format {
    override fun parse(instruction: Int): String {
        val opCode = instruction.getBits(10, 0b11)

        val o = instruction.getBits(6, 0b111)
        val b = instruction.getBits(3, 0b111)
        val d = instruction.getBits(0, 0b111)

        val opType = when (opCode) {
            0b00 -> "STR"
            0b01 -> "STRB"
            0b10 -> "LDR"
            0b11 -> "LDRB"
            else -> error("unreachable")
        }

        return "$opType R$d, [R$b, R$o]"
    }
}
