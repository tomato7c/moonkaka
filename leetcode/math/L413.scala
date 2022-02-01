object Solution {
    // 双指针 + 数学...
    // 双指针枚举等差数列的每个左端点，j为最右端点, 知道[i.j]范围后，可以计算出子数列的数量
    def numberOfArithmeticSlices(arr: Array[Int]): Int = {
        var res = 0
        var i = 0
        while (i < arr.length - 1) {
             val d = arr(i + 1) - arr(i)
            var j = i
            while (j + 1 < arr.length && arr(j + 1) - arr(j) == d) j += 1
            val size = j - i + 1
            if (size >= 3) {
                val a1 = 1; val an = size - 3 + 1
                // 等差数列求和
                res += (a1 + an)*an / 2
            }
            i = j
        }
        res
    }
}