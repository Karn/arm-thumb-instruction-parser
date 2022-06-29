/**
 *  Format 5: Hi register operations/branch exchange
 */
object Format5 : Format {
    override fun parse(instruction: Int): String {
        val op = instruction.getBits(8, 0b11)

        val flag = instruction.getBits(6, 0b11)

        val s = instruction.getBits(3, 0b111)
        val d = instruction.getBits(0, 0b111)

        return when (op) {
            0b00 -> {
                val type = when (flag) {
                    0b00 -> "R$d, H$s"
                    0b10 -> "H$d, R$s"
                    0b11 -> "H$d, H$s"
                    else -> error("unreachable")
                }

                "ADD $type"
            }
            0b01 -> {
                val type = when (flag) {
                    0b00 -> "R$d, H$s"
                    0b10 -> "H$d, R$s"
                    0b11 -> "H$d, H$s"
                    else -> error("unreachable")
                }

                "CMP $type"
            }
            0b10 -> {
                val type = when (flag) {
                    0b00 -> "R$d, H$s"
                    0b10 -> "H$d, R$s"
                    0b11 -> "H$d, H$s"
                    else -> error("unreachable")
                }

                "MOV $type"
            }
            0b11 -> {
                val type = when (flag) {
                    0b00 -> "R$s"
                    0b01 -> "H$s"
                    else -> error("unreachable")
                }

                "BX $type"
            }
            else -> error("unreachable")
        }
    }
}
