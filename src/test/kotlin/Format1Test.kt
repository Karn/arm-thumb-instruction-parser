import org.junit.jupiter.api.Test

class Format1Test {
    @Test
    fun `parsing a format 1 instruction`() {
        val cases = listOf(
            0b000_00_00000_000_000 to "LSL R0, R0, #0",
            0b000_00_01010_001_010 to "LSL R2, R1, #10",
            0b000_01_00000_000_000 to "LSR R0, R0, #0",
            0b000_01_11111_011_110 to "LSR R6, R3, #31",
            0b000_10_00000_000_000 to "ASR R0, R0, #0",
            0b000_10_01101_100_011 to "ASR R3, R4, #13",
        )

        for ((instruction, expected) in cases) {
            val actual = Format1.parse(instruction)
            assert(actual == expected) {
                "failed to parse instruction to format-1 0b${
                    instruction.toString(2).padStart(16, '0').chunked(4).joinToString("_")
                }, expected $expected but got $actual"
            }
        }
    }
}