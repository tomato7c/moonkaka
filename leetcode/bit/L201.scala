object L201 {
    // 画图好理解, 拆分子问题的思想
    def rangeBitwiseAnd(_left: Int, _right: Int): Int = {
        var zeros = 0
        var left = _left; var right = _right
        while (left < right) {
            zeros += 1
            left >>>= 1
            right >>>= 1
        }
        left << zeros
    }
}