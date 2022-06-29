/**
 * Format 2: add/subtract
 */
object Format2 : Format {

    override fun parse(instruction: Int): String {
        val immediateFlag = instruction.getBits(10, 0b1)
        val op = instruction.getBits(9, 0b1)

        val rnOrOffset3 = instruction.getBits(6, 0b111)

        val s = instruction.getBits(3, 0b111)
        val d = instruction.getBits(0, 0b111)

        val opType = when (op) {
            0b0 -> "ADD"
            0b1 -> "SUB"
            else -> error("unreachable")
        }

        val offsetType = when (immediateFlag) {
            0b0 -> "R"
            0b1 -> "#"
            else -> error("unreachable")
        }

        return "$opType R$d, R$s, $offsetType$rnOrOffset3"
    }
}
