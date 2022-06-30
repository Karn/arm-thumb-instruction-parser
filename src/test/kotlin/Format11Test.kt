import org.junit.jupiter.api.Test

class Format11Test {

    @Test
    fun `parsing a format 11 instruction`() {
        val cases = listOf(
            0b1001_0_000_00000000 to "STR R0, [SP, #0]",
            0b1001_1_000_00000000 to "LDR R0, [SP, #0]",
        )

        for ((instruction, expected) in cases) {
            val actual = Format11.parse(instruction)
            assert(actual == expected) {
                "failed to parse instruction to format-11 0b${instruction.toString(2).padStart(16, '0').chunked(4).joinToString("_")}, expected $expected but got $actual"
            }
        }
    }
}