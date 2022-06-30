/**
 * Format 19: long branch with link
 */
object Format19 : Format {
    override fun parse(instruction: Int): String {
        val flag = instruction.getBits(11, 0b1)
        val offset11 = instruction.getBits(0, 0b11111111111)

        return when (flag) {
            0b0 -> "BL LR = PC + ${offset11 shl 12}"
            0b1 -> "BL LR += ${(offset11 shl 1) or 1}, PC = LR, LR = 0"
            else -> error("unreachable")
        }
    }
}
