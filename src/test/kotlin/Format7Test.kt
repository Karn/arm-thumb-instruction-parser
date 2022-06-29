import org.junit.jupiter.api.Test

class Format7Test {

    @Test
    fun `parsing a format 7 instruction`() {
        val cases = listOf(
            0b0101_0_0_0_000_000_000 to "STR R0, [R0, R0]",
            0b0101_0_1_0_000_000_000 to "STRB R0, [R0, R0]",
            0b0101_1_0_0_000_000_000 to "LDR R0, [R0, R0]",
            0b0101_1_1_0_000_000_000 to "LDRB R0, [R0, R0]",
        )

        for ((instruction, expected) in cases) {
            val actual = Format7.parse(instruction)
            assert(actual == expected) {
                "failed to parse instruction to format-7 0b${instruction.toString(2).padStart(16, '0').chunked(4).joinToString("_")}, expected $expected but got $actual"
            }
        }
    }
}