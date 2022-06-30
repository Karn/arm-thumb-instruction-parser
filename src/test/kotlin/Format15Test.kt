import org.junit.jupiter.api.Test

class Format15Test {

    @Test
    fun `parsing a format 15 instruction`() {
        val cases = listOf(
            0b1100_0_001_00000001 to "STMIA R1! {R0}",
            0b1100_0_010_00100101 to "STMIA R2! {R0,R2,R5}",
            0b1100_1_001_00000001 to "LDMIA R1! {R0}",
            0b1100_1_010_00100101 to "LDMIA R2! {R0,R2,R5}",
        )

        for ((instruction, expected) in cases) {
            val actual = Format15.parse(instruction)
            assert(actual == expected) {
                "failed to parse instruction to format-15 0b${
                    instruction.toString(2).padStart(16, '0').chunked(4).joinToString("_")
                }, expected $expected but got $actual"
            }
        }
    }
}