/**
 * Format 6: PC-relative load
 */
object Format6 : Format {
    override fun parse(instruction: Int): String {
        val d = instruction.getBits(8, 0b111)

        val word8 = instruction.getBits(0, 0b11111111)

        return "LDR R$d, [PC, #$word8]"
    }
}
