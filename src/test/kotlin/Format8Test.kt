import org.junit.jupiter.api.Test

class Format8Test {

    @Test
    fun `parsing a format 8 instruction`() {
        val cases = listOf(
            0b0101_0_0_1_000_000_000 to "STRH R0, [R0, R0]",
            0b0101_0_1_1_000_000_000 to "LDSB R0, [R0, R0]",
            0b0101_1_0_1_000_000_000 to "LDRH R0, [R0, R0]",
            0b0101_1_1_1_000_000_000 to "LDSH R0, [R0, R0]",
        )

        for ((instruction, expected) in cases) {
            val actual = Format8.parse(instruction)
            assert(actual == expected) {
                "failed to parse instruction to format-8 0b${
                    instruction.toString(2).padStart(16, '0').chunked(4).joinToString("_")
                }, expected $expected but got $actual"
            }
        }
    }
}