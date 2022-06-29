/**
 * Format 4: ALU operations
 */
object Format4 : Format {
    override fun parse(instruction: Int): String {
        val op = instruction.getBits(6, 0b1111)

        val s = instruction.getBits(3, 0b111)
        val d = instruction.getBits(0, 0b111)

        val opType = when (op) {
            0b0000 -> "AND"
            0b0001 -> "EOR"
            0b0010 -> "LSL"
            0b0011 -> "LSR"
            0b0100 -> "ASR"
            0b0101 -> "ADC"
            0b0110 -> "SBC"
            0b0111 -> "ROR"
            0b1000 -> "TST"
            0b1001 -> "NEG"
            0b1010 -> "CMP"
            0b1011 -> "CMN"
            0b1100 -> "ORR"
            0b1101 -> "MUL"
            0b1110 -> "BIC"
            0b1111 -> "MVN"
            else -> error("unreachable")
        }

        return "$opType R$d R$s"
    }
}
