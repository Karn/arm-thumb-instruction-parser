import org.junit.jupiter.api.Test

class Format4Test {

    @Test
    fun `parsing a format 4 instruction`() {
        val cases = listOf(
            0b010000_0000_000_000 to "AND R0 R0",
            0b010000_0001_000_000 to "EOR R0 R0",
            0b010000_0010_000_000 to "LSL R0 R0",
            0b010000_0011_000_000 to "LSR R0 R0",
            0b010000_0100_000_000 to "ASR R0 R0",
            0b010000_0101_000_000 to "ADC R0 R0",
            0b010000_0110_000_000 to "SBC R0 R0",
            0b010000_0111_000_000 to "ROR R0 R0",
            0b010000_1000_000_000 to "TST R0 R0",
            0b010000_1001_000_000 to "NEG R0 R0",
            0b010000_1010_000_000 to "CMP R0 R0",
            0b010000_1011_000_000 to "CMN R0 R0",
            0b010000_1100_000_000 to "ORR R0 R0",
            0b010000_1101_000_000 to "MUL R0 R0",
            0b010000_1110_000_000 to "BIC R0 R0",
            0b010000_1111_000_000 to "MVN R0 R0",
        )

        for ((instruction, expected) in cases) {
            val actual = Format4.parse(instruction)
            assert(actual == expected) {
                "failed to parse instruction to format-4 0b${instruction.toString(2).padStart(16, '0').chunked(4).joinToString("_")}, expected $expected but got $actual"
            }
        }
    }
}