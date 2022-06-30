import org.junit.jupiter.api.Test

class Format14Test {

    @Test
    fun `parsing a format 14 instruction`() {
        val cases = listOf(
            0b1011_0_10_0_00000001 to "PUSH {R0}",
            0b1011_0_10_0_00000101 to "PUSH {R0,R2}",
            0b1011_0_10_1_00000001 to "PUSH {R0,LR}",
            0b1011_0_10_1_00000101 to "PUSH {R0,R2,LR}",
            0b1011_1_10_0_00000001 to "POP {R0}",
            0b1011_1_10_0_00000101 to "POP {R0,R2}",
            0b1011_1_10_1_00000001 to "POP {R0,PC}",
            0b1011_1_10_1_00000101 to "POP {R0,R2,PC}",
        )

        for ((instruction, expected) in cases) {
            val actual = Format14.parse(instruction)
            assert(actual == expected) {
                "failed to parse instruction to format-14 0b${
                    instruction.toString(2).padStart(16, '0').chunked(4).joinToString("_")
                }, expected $expected but got $actual"
            }
        }
    }
}