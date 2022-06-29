/**
 * Format 8: load/store sign-extended byte/halfword
 */
object Format8 : Format {
    override fun parse(instruction: Int): String {
        val opCode = instruction.getBits(10, 0b11)

        val o = instruction.getBits(6, 0b111)
        val b = instruction.getBits(3, 0b111)
        val d = instruction.getBits(0, 0b111)

        val opType = when (opCode) {
            0b00 -> "STRH"
            0b01 -> "LDSB"
            0b10 -> "LDRH"
            0b11 -> "LDSH"
            else -> error("unreachable")
        }

        return "$opType R$d, [R$b, R$o]"
    }
}
