/**
 * Format 9: load/store with immediate offset
 */
object Format10 : Format {
    override fun parse(instruction: Int): String {
        val lbFlag = instruction.getBits(11, 0b11)

        val offset5 = instruction.getBits(6, 0b11111)

        val b = instruction.getBits(3, 0b111)
        val d = instruction.getBits(0, 0b111)

        val lbFlagType = when (lbFlag) {
            0b00 -> "STR"
            0b01 -> "STRB"
            0b10 -> "LDR"
            0b11 -> "LDRB"
            else -> error("unreachable")
        }

        return "$lbFlagType R$d, [R$b, #$offset5]"
    }
}
