/**
 * TODO: Deprecate this in favor of a function that returns the bits based on range.
 *  e.g getBits(12..10) which returns the bits from position 12, 11, and 10
 */
inline fun Int.getBits(rtlPosition: Int, rtlSize: Int = 0b1): Int {
    return (this shr rtlPosition) and rtlSize
}