/**
 * Format 1: move shifted register
 *
 * 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0
 * 0 0 0 -Op-- ---Offset5--- -Rs-- -Rd--
 *
 * Op: Op Code
 *  0 - LSL
 *  1 - LSR
 *  2 - ASR
 * Offset5: Immediate value
 * Rs: Source register
 * Rd: Destination register
 *
 * TODO: ARM equivalent
 */
fun parseFormat1(instruction: Int): String {
    val op = instruction.getBits(11, 0b11)

    require(op != 0b11) {
        "invalid opcode, must be 0 - LSL, 1 - LSR, or 2 - ASR"
    }

    val offset5 = instruction.getBits(6, 0b11111)
    val s = instruction.getBits(3, 0b111)
    val d = instruction.getBits(0, 0b111)

    val opType = when (op) {
        0b00 -> "LSL"
        0b01 -> "LSR"
        0b10 -> "ASR"
        else -> error("unreachable")
    }

    return "$opType R$d, R$s, #${offset5}"
}