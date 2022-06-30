import org.junit.jupiter.api.Test

class Format10Test {

    @Test
    fun `parsing a format 10 instruction`() {
        val cases = listOf(
            0b1000_0_00000_000_000 to "STRH R0, [R0, #0]",
            0b1000_1_00000_000_000 to "LDRH R0, [R0, #0]",
        )

        for ((instruction, expected) in cases) {
            val actual = Format10.parse(instruction)
            assert(actual == expected) {
                "failed to parse instruction to format-10 0b${instruction.toString(2).padStart(16, '0').chunked(4).joinToString("_")}, expected $expected but got $actual"
            }
        }
    }
}