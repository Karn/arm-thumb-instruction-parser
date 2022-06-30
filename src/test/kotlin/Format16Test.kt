import org.junit.jupiter.api.Test

class Format16Test {

    @Test
    fun `parsing a format 16 instruction`() {
        val cases = listOf(
            0b1101_0000_00000000 to "BEQ #1",
            0b1101_0000_00000100 to "BEQ #9",
            0b1101_0001_00000000 to "BNE #1",
            0b1101_0010_00000000 to "BCS #1",
            0b1101_0011_00000000 to "BCC #1",
            0b1101_0100_00000000 to "BMI #1",
            0b1101_0101_00000000 to "BPL #1",
            0b1101_0110_00000000 to "BVS #1",
            0b1101_0111_00000000 to "BVC #1",
            0b1101_1000_00000000 to "BHI #1",
            0b1101_1001_00000000 to "BLS #1",
            0b1101_1010_00000000 to "BGE #1",
            0b1101_1011_00000000 to "BLT #1",
            0b1101_1100_00000000 to "BGT #1",
            0b1101_1101_00000000 to "BLE #1",
        )

        for ((instruction, expected) in cases) {
            val actual = Format16.parse(instruction)
            assert(actual == expected) {
                "failed to parse instruction to format-16 0b${
                    instruction.toString(2).padStart(16, '0').chunked(4).joinToString("_")
                }, expected $expected but got $actual"
            }
        }
    }
}