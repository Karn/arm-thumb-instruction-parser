fun parseThumbInstructionFormat(instruction: Int): Int {
    // Assert that the instruction in within the correct bounds
    require(instruction in 0..0xFFFF) {
        "instruction $instruction is outside the valid range (0..${0xFFFF})"
    }

    // Grab the opcode which is the first 3 bits so we right shift 13 bits
    val opCode = instruction shr 13

    // Fork on the opCode
    // TODO: Is a regex easier to understand?
    // TODO: We can actually use a mask + xor
    return when (opCode) {
        // 1, 2
        0b000 -> if (instruction.getBits(11, 0b11) == 0b11) 2 else 1
        // 3
        0b001 -> 3
        // 4, 5, 6, 7, 8
        0b010 -> {
            val flag = instruction.getBits(11, 0b11)
            when {
                flag == 0b00 -> if (instruction.getBits(10, 0b1) == 1) 5 else 4
                flag == 0b01 -> 6
                flag >= 0b10 -> {
                    if (instruction.getBits(9, 0b1) == 1) 8 else 7
                }
                else ->  error("invalid flag, $flag, for 4/5/6/7/8 format parsing")
            }
        }
        // 9
        0b011 -> 9
        // 10, 11
        0b100 -> if (instruction.getBits(12, 0b1) == 1) 11 else 10
        // 12, 13, 14
        0b101 -> {
            val flag = instruction.getBits(12, 0b1)
            if (flag == 0) {
                12
            } else {
                when (val flag2 = instruction.getBits(10, 0b11)) {
                    0b00 -> 13
                    0b01 -> 14
                    0b11 -> 14
                    else -> error("invalid flag, $flag2, for 13/14 format parsing")
                }
            }
        }
        // 15, 16, 17
        0b110 -> {
            val flag = instruction.getBits(12, 0b1)
            if (flag == 0) {
                15
            } else {
                when (instruction.getBits(8, 0b1111)) {
                    0b1111 -> 17
                    else -> 16
                }
            }
        }
        // 18, 19
        0b111 -> if (instruction.getBits(12, 0b1) == 1) 19 else 18
        else -> error("invalid instruction opcode -- $opCode")
    }
}

