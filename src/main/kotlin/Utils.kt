/**
 * TODO: Deprecate this in favor of a function that returns the bits based on range.
 *  e.g getBits(12..10) which returns the bits from position 12, 11, and 10
 */
inline fun Int.getBits(rtlPosition: Int, rtlSize: Int = 0b1): Int {
    return (this shr rtlPosition) and rtlSize
}

// TODO: Figure out if it makes sense to also do ranges if we have 3+ consecutive registers.
fun getRegisterListFromBitRepresentation(list: Int): String {
    require(list in 0b0..0b11111111) {
        "invalid register list provided"
    }

    return (0..7).mapNotNull { register ->
        if (list.getBits(register, 0b1) == 0b1) {
            "R$register"
        } else {
            null
        }
    }.joinToString(",")
}