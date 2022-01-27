object Solution {
    // 数学模拟，针对每位为1时分情况讨论 eg abcde
    // c == 0时，左[0,ab), 右[0,999]
    // c == 1时，左[0,ab) 右[0,999] 加上左[ab,ab] 右[0,def]
    // c > 1时，左[0,ab], 右[0,999]
    def countDigitOne(_n: Int): Int = {
        var n = _n
        val list = collection.mutable.ListBuffer[Int]()
        while (n > 0) {
            list += n % 10
            n /= 10
        }
        val arr = list.reverse.toArray

        var res = 0; val end = arr.length - 1
        for (i <- arr.indices) {
            val c = arr(i)
            val left = rangeValue(arr, 0, i - 1)
            val right = rangeValue(arr, i + 1, end)
            if (c == 0) res += left * rangeFull(i + 1, end)
            else if (c == 1) res += left * rangeFull(i + 1, end) + right + 1
            else res += (left + 1) * rangeFull(i + 1, end)
        }
        res
    }

    private def rangeValue(arr: Array[Int], begin: Int, end: Int): Int = {
        var res = 0
        for (i <- begin to end) {
            res *= 10
            res += arr(i)
        }
        res
    }

    // 2, 5 => 1000
    private def rangeFull(begin: Int, end: Int): Int = {
        var res = 1
        for (temp <- begin to end) {
            res *= 10
        }
        res
    }
}