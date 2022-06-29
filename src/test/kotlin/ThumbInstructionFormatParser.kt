import org.junit.jupiter.api.Test

class ThumbInstructionFormatParser {

    @Test
    fun `test thumb instruction format parsing`() {
        val cases = listOf(
            0b0000_0000_0000_0000 to 1,
            0b0000_1000_0000_0000 to 1,
            0b0001_0000_0000_0000 to 1,
            0b0001_1000_0000_0000 to 2,
            0b0010_0000_0000_0000 to 3,
            0b0100_0000_0000_0000 to 4,
            0b0100_0100_0000_0000 to 5,
            0b0100_1000_0000_0000 to 6,
            0b0101_0000_0000_0000 to 7,
            0b0101_0010_0000_0000 to 8,
            0b0110_0000_0000_0000 to 9,
            0b1000_0000_0000_0000 to 10,
            0b1001_0000_0000_0000 to 11,
            0b1010_0000_0000_0000 to 12,
            0b1011_0000_0000_0000 to 13,
            0b1011_0100_0000_0000 to 14,
            // 0b1011_1000_0000_0000 to invalid
            0b1011_1100_0000_0000 to 14,
            0b1100_0000_0000_0000 to 15,
            0b1101_0000_0000_0000 to 16,
            0b1101_0001_0000_0000 to 16,
            0b1101_0010_0000_0000 to 16,
            0b1101_0011_0000_0000 to 16,
            0b1101_0100_0000_0000 to 16,
            0b1101_0101_0000_0000 to 16,
            0b1101_0110_0000_0000 to 16,
            0b1101_0111_0000_0000 to 16,
            0b1101_1000_0000_0000 to 16,
            0b1101_1001_0000_0000 to 16,
            0b1101_1010_0000_0000 to 16,
            0b1101_1011_0000_0000 to 16,
            0b1101_1100_0000_0000 to 16,
            0b1101_1101_0000_0000 to 16,
            0b1101_1110_0000_0000 to 16,
            0b1101_1111_0000_0000 to 17,
            0b1110_0000_0000_0000 to 18,
            0b1111_0000_0000_0000 to 19,
        )

        for ((instruction, expectedFormat) in cases) {
            assert(parseThumbInstructionFormat(instruction) == expectedFormat) {
                "failed to parse thumb instruction format for 0b${instruction.toString(2).padStart(16, '0').chunked(4).joinToString("_")}, expected Format-$expectedFormat"
            }
        }
    }
}