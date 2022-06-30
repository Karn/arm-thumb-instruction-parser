/**
 * Format 11: SP-relative load/store
 */
object Format11 : Format {
    override fun parse(instruction: Int): String {
        val lFlag = instruction.getBits(11, 0b1)

        val d = instruction.getBits(8, 0b111)

        val word8 = instruction.getBits(0, 0b11111111)

        val lFlagType = when (lFlag) {
            0b0 -> "STR"
            0b1 -> "LDR"
            else -> error("unreachable")
        }

        return "$lFlagType R$d, [SP, #$word8]"
    }
}
