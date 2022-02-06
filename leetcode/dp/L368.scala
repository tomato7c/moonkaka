import scala.util.control.Breaks.{break, breakable}
object Solution {
    // 如果排序后, a与b, b与c成倍数关系，则a与c成倍数关系
    // 排序后问题类似于求最长上升子序列
    // f(i)表示以arr(i)结尾的最长除数子集
    def largestDivisibleSubset(nums: Array[Int]): List[Int] = {
        val arr = nums.sortWith(_<_)
        val n = arr.length
        val dp = new Array[Int](n)
        for (i <- dp.indices) dp(i) = 1 // 每个数自己是一个结果集

        var k = 0
        for (i <- 1 until n; j <- 0 until i) {
            if (arr(i) % arr(j) == 0) {
                if (dp(i) < dp(j) + 1) {
                    dp(i) = dp(j) + 1
                    if (dp(k) < dp(i)) k = i
                }
            }
        }
        // 由k倒推路径
        val res = collection.mutable.ListBuffer[Int]()
        res += arr(k)
        while (dp(k) > 1) {
            breakable({
                for (i <- 0 until k if arr(k) % arr(i) == 0 && dp(k) == dp(i) + 1) {
                    res += arr(i)
                    k = i
                    break
                }
            })
        }
        res.toList
    }
}