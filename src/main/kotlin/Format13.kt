/**
 * Format 13: add offset to Stack Pointer
 */
object Format13 : Format {
    override fun parse(instruction: Int): String {
        val sign = instruction.getBits(7, 0b1)

        val d = instruction.getBits(8, 0b111)

        val sWord7 = instruction.getBits(0, 0b1111111)

        val offsetType = when (sign) {
            0b0 -> "#"
            0b1 -> "#-"
            else -> error("unreachable")
        }

        return "ADD SP, $offsetType$sWord7"
    }
}
