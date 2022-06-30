/**
 * Format 16: conditional branch
 */
object Format16 : Format {
    override fun parse(instruction: Int): String {
        val cond = instruction.getBits(8, 0b1111)

        val sOffset8 = instruction.getBits(0, 0b11111111)

        val opType = when (cond) {
            0b0000 -> "BEQ"
            0b0001 -> "BNE"
            0b0010 -> "BCS"
            0b0011 -> "BCC"
            0b0100 -> "BMI"
            0b0101 -> "BPL"
            0b0110 -> "BVS"
            0b0111 -> "BVC"
            0b1000 -> "BHI"
            0b1001 -> "BLS"
            0b1010 -> "BGE"
            0b1011 -> "BLT"
            0b1100 -> "BGT"
            0b1101 -> "BLE"
            else -> error("unreachable")
        }

        return "$opType #${sOffset8 + 1}" // PC + 1 (prefetch) + sOffset8
    }
}
