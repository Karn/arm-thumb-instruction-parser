/**
 * Format 17: software interrupt
 */
object Format17 : Format {
    override fun parse(instruction: Int): String {
        val value8 = instruction.getBits(0, 0b11111111)

        return "SWI $value8"
    }
}
