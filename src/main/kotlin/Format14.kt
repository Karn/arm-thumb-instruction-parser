/**
 * Format 14: push/pop registers
 */
object Format14 : Format {
    override fun parse(instruction: Int): String {
        val l = instruction.getBits(11, 0b1)
        val r = instruction.getBits(8, 0b1)

        val rlist = instruction.getBits(0, 0b11111111)

        return when {
            l == 0b0 && r == 0b0 -> "PUSH {${getRegisterListFromBitRepresentation(rlist)}}"
            l == 0b0 && r == 0b1 -> "PUSH {${getRegisterListFromBitRepresentation(rlist)},LR}"
            l == 0b1 && r == 0b0 -> "POP {${getRegisterListFromBitRepresentation(rlist)}}"
            l == 0b1 && r == 0b1 -> "POP {${getRegisterListFromBitRepresentation(rlist)},PC}"
            else -> error("unreachable")
        }
    }
}
