import org.junit.jupiter.api.Test

class Format12Test {

    @Test
    fun `parsing a format 12 instruction`() {
        val cases = listOf(
            0b1010_0_000_00000000 to "ADD R0, PC, #0",
            0b1010_1_000_00000000 to "ADD R0, SP, #0",
        )

        for ((instruction, expected) in cases) {
            val actual = Format12.parse(instruction)
            assert(actual == expected) {
                "failed to parse instruction to format-12 0b${
                    instruction.toString(2).padStart(16, '0').chunked(4).joinToString("_")
                }, expected $expected but got $actual"
            }
        }
    }
}