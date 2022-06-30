/**
 * Format 10: load/store halfword
 */
object Format10 : Format {
    override fun parse(instruction: Int): String {
        val lFlag = instruction.getBits(11, 0b1)

        val offset5 = instruction.getBits(6, 0b11111)

        val b = instruction.getBits(3, 0b111)
        val d = instruction.getBits(0, 0b111)

        val lFlagType = when (lFlag) {
            0b0 -> "STRH"
            0b1 -> "LDRH"
            else -> error("unreachable")
        }

        return "$lFlagType R$d, [R$b, #$offset5]"
    }
}
