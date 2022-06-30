import org.junit.jupiter.api.Test

class Format13Test {

    @Test
    fun `parsing a format 13 instruction`() {
        val cases = listOf(
            0b10110000_0_0000001 to "ADD SP, #1",
            0b10110000_1_0000001 to "ADD SP, #-1",
        )

        for ((instruction, expected) in cases) {
            val actual = Format13.parse(instruction)
            assert(actual == expected) {
                "failed to parse instruction to format-13 0b${
                    instruction.toString(2).padStart(16, '0').chunked(4).joinToString("_")
                }, expected $expected but got $actual"
            }
        }
    }
}