object Solution {
    def missingNumber(arr: Array[Int]): Int = {
        val n = arr.length
        var total = (1 + n) * n / 2.0
        for (v <- arr) total -= v
        total.toInt
    }
}