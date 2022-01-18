object L190 {
    // x右移，res左移
    def reverseBits(_x: Int): Int = {
        var x = _x
        var res = 0
        for (i <- 0 until 32) {
            val t = x >> i
            if ((t & 1) == 1) res |= 1 << (31 - i)
        }
        res
    }
}