import org.junit.jupiter.api.Test

class Format3Test {

    @Test
    fun `parsing a format 3 instruction`() {
        val cases = listOf(
            0b001_00_000_00000000 to "MOV R0 #0",
            0b001_00_010_01010101 to "MOV R2 #85",
            0b001_01_000_00000000 to "CMP R0 #0",
            0b001_01_010_01010101 to "CMP R2 #85",
            0b001_10_000_00000000 to "ADD R0 #0",
            0b001_10_010_01010101 to "ADD R2 #85",
            0b001_11_000_00000000 to "SUB R0 #0",
            0b001_11_010_01010101 to "SUB R2 #85",
        )

        for ((instruction, expected) in cases) {
            val actual = Format3.parse(instruction)
            assert(actual == expected) {
                "failed to parse instruction to format-3 0b${instruction.toString(2).padStart(16, '0').chunked(4).joinToString("_")}, expected $expected but got $actual"
            }
        }
    }
}