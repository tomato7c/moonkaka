object L390 {
    // 只要从左往右，一定会更新起点, 当剩余奇数时，也会消除起点； 每次转换方向，n减半，到达下一次起点跳跃的距离加倍
    def lastRemaining(_n: Int): Int = {
        var isLeftToRight = true
        var first = 1
        var distance = 1
        var n = _n
        while (n > 1) {
            if (isLeftToRight || isOdd(n)) first += distance

            isLeftToRight = !isLeftToRight
            n /= 2
            distance *= 2
        }
        first
    }

    private def isOdd(v: Int): Boolean = (v & 1) == 1
}