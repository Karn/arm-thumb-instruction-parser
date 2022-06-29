import org.junit.jupiter.api.Test

class Format9Test {

    @Test
    fun `parsing a format 9 instruction`() {
        val cases = listOf(
            0b011_0_0_00000_000_000 to "STR R0, [R0, #0]",
            0b011_0_0_00000_010_100 to "STR R4, [R2, #0]",
            0b011_0_1_00000_000_000 to "LDR R0, [R0, #0]",
            0b011_0_1_10000_010_100 to "LDR R4, [R2, #16]",
            0b011_1_0_10000_000_000 to "STRB R0, [R0, #16]",
            0b011_1_0_00000_111_100 to "STRB R4, [R7, #0]",
            0b011_1_1_11111_000_000 to "LDRB R0, [R0, #31]",
            0b011_1_1_00000_010_100 to "LDRB R4, [R2, #0]",
        )

        for ((instruction, expected) in cases) {
            val actual = Format9.parse(instruction)
            assert(actual == expected) {
                "failed to parse instruction to format-9 0b${instruction.toString(2).padStart(16, '0').chunked(4).joinToString("_")}, expected $expected but got $actual"
            }
        }
    }
}