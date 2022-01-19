object L209 {
    // 滑动窗口，一般通过暴力法排除方式优化到滑动窗口
    def minSubArrayLen(target: Int, arr: Array[Int]): Int = {
        var sum = 0
        var min = Int.MaxValue
        var left = 0; var right = 0
        while (right < arr.length) {
            sum += arr(right)
            while (sum >= target) {
                min = Math.min(min, right - left + 1)
                sum -= arr(left)
                left += 1
            }
            right += 1
        }
        if (min == Int.MaxValue) 0 else min
    }
}
