object Solution {
    def numberOfSteps(num: Int): Int = {
        var n = num
        var res = 0
        while (n != 0) {
            if ((n & 1) == 0) {
                n >>= 1
            } else {
                // 末尾1翻转成0
                n ^= 1
            }
            res += 1
        }
        res
    }
}