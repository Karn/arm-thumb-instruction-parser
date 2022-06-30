/**
 * Format 15: multiple load/store
 */
object Format15 : Format {
    override fun parse(instruction: Int): String {
        val l = instruction.getBits(11, 0b1)
        val b = instruction.getBits(8, 0b111)

        val rlist = instruction.getBits(0, 0b11111111)

        val opType = when (l) {
            0b0 -> "STMIA"
            0b1 -> "LDMIA"
            else -> error("unreachable")
        }

        return "$opType R$b! {${getRegisterListFromBitRepresentation(rlist)}}"
    }
}
