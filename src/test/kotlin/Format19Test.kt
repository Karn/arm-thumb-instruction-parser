import org.junit.jupiter.api.Test

class Format19Test {

    @Test
    fun `parsing a format 19 instruction`() {
        val cases = listOf(
            0b1111_0_00000000001 to "BL LR = PC + 4096",
            0b1111_0_10000000000 to "BL LR = PC + 4194304",
            0b1111_1_00000000001 to "BL LR += 3, PC = LR, LR = 0",
            0b1111_1_10000000001 to "BL LR += 2051, PC = LR, LR = 0",
        )

        for ((instruction, expected) in cases) {
            val actual = Format19.parse(instruction)
            assert(actual == expected) {
                "failed to parse instruction to format-19 0b${
                    instruction.toString(2).padStart(16, '0').chunked(4).joinToString("_")
                }, expected $expected but got $actual"
            }
        }
    }
}