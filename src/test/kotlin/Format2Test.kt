import org.junit.jupiter.api.Test

class Format2Test {

    @Test
    fun `parsing a format 2 instruction`() {
        val cases = listOf(
            0b00011_0_0_000_000_000 to "ADD R0, R0, R0",
            0b00011_0_0_100_010_001 to "ADD R1, R2, R4",
            0b00011_1_0_000_000_000 to "ADD R0, R0, #0",
            0b00011_1_0_100_010_001 to "ADD R1, R2, #4",
            0b00011_0_1_000_000_000 to "SUB R0, R0, R0",
            0b00011_0_1_100_010_001 to "SUB R1, R2, R4",
            0b00011_1_1_000_000_000 to "SUB R0, R0, #0",
            0b00011_1_1_100_010_001 to "SUB R1, R2, #4",
        )

        for ((instruction, expected) in cases) {
            val actual = Format2.parse(instruction)
            assert(actual == expected) {
                "failed to parse instruction to format-2 0b${instruction.toString(2).padStart(16, '0').chunked(4).joinToString("_")}, expected $expected but got $actual"
            }
        }
    }
}