/**
 * Format 18: unconditional branch
 */
object Format18 : Format {
    override fun parse(instruction: Int): String {
        val offset11 = instruction.getBits(0, 0b11111111111)

        return "B #${offset11 + 1}" // PC + 1 (prefetch) + sOffset8
    }
}
