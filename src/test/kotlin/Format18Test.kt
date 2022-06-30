import org.junit.jupiter.api.Test

class Format18Test {

    @Test
    fun `parsing a format 18 instruction`() {
        val cases = listOf(
            0b11100_0000000000 to "B #1",
            0b11100_0111111111 to "B #512",
            0b11100_1000000000 to "B #513",
        )

        for ((instruction, expected) in cases) {
            val actual = Format18.parse(instruction)
            assert(actual == expected) {
                "failed to parse instruction to format-18 0b${
                    instruction.toString(2).padStart(16, '0').chunked(4).joinToString("_")
                }, expected $expected but got $actual"
            }
        }
    }
}