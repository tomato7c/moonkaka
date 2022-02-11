object Solution {
    // 排序后，容易通过反证法证明k个数必然连续
    def minimumDifference(nums: Array[Int], k: Int): Int = {
        val arr = nums.sortWith(_<_)
        var res = Int.MaxValue
        for (i <- 0 to arr.length - k) {
            val diff = arr(i + k - 1) - arr(i)
            res = res.min(diff)
        }
        res
    }
}