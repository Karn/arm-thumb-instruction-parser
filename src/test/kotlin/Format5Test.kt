import org.junit.jupiter.api.Test

class Format5Test {

    @Test
    fun `parsing a format 5 instruction`() {
        val cases = listOf(
            0b010001_00_0_0_000_000 to "ADD R0, H0",
            0b010001_00_1_0_000_000 to "ADD H0, R0",
            0b010001_00_1_1_000_000 to "ADD H0, H0",
            0b010001_01_0_0_000_000 to "CMP R0, H0",
            0b010001_01_1_0_000_000 to "CMP H0, R0",
            0b010001_01_1_1_000_000 to "CMP H0, H0",
            0b010001_10_0_0_000_000 to "MOV R0, H0",
            0b010001_10_1_0_000_000 to "MOV H0, R0",
            0b010001_10_1_1_000_000 to "MOV H0, H0",
            0b010001_11_0_0_000_000 to "BX R0",
            0b010001_11_0_1_000_000 to "BX H0",
        )

        for ((instruction, expected) in cases) {
            val actual = Format5.parse(instruction)
            assert(actual == expected) {
                "failed to parse instruction to format-5 0b${instruction.toString(2).padStart(16, '0').chunked(4).joinToString("_")}, expected $expected but got $actual"
            }
        }
    }
}