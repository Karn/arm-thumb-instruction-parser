import org.junit.jupiter.api.Test

class Format6Test {

    @Test
    fun `parsing a format 6 instruction`() {
        val cases = listOf(
            0b01001_000_00000000 to "LDR R0, [PC, #0]",
            0b01001_111_00000000 to "LDR R7, [PC, #0]",
            0b01001_110_00100101 to "LDR R6, [PC, #37]",
        )

        for ((instruction, expected) in cases) {
            val actual = Format6.parse(instruction)
            assert(actual == expected) {
                "failed to parse instruction to format-6 0b${instruction.toString(2).padStart(16, '0').chunked(4).joinToString("_")}, expected $expected but got $actual"
            }
        }
    }
}