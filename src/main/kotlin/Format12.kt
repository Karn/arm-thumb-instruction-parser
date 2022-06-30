/**
 * Format 12: load address
 */
object Format12 : Format {
    override fun parse(instruction: Int): String {
        val source = instruction.getBits(11, 0b1)

        val d = instruction.getBits(8, 0b111)

        val word8 = instruction.getBits(0, 0b11111111)

        val sourceType = when (source) {
            0b0 -> "PC"
            0b1 -> "SP"
            else -> error("unreachable")
        }

        return "ADD R$d, $sourceType, #$word8"
    }
}
