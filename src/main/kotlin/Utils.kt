inline fun Int.getBits(rtlPosition: Int, rtlSize: Int = 0b1): Int {
    return (this shr rtlPosition) and rtlSize
}