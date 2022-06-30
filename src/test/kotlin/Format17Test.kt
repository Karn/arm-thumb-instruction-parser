import org.junit.jupiter.api.Test

class Format17Test {

    @Test
    fun `parsing a format 17 instruction`() {
        val cases = listOf(
            0b1101_1111_00000000 to "SWI 0",
            0b1101_1111_00000100 to "SWI 4",
            0b1101_1111_10000000 to "SWI 128",
        )

        for ((instruction, expected) in cases) {
            val actual = Format17.parse(instruction)
            assert(actual == expected) {
                "failed to parse instruction to format-17 0b${
                    instruction.toString(2).padStart(16, '0').chunked(4).joinToString("_")
                }, expected $expected but got $actual"
            }
        }
    }
}