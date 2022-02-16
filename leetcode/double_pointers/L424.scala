object Solution {
    // 滑动窗口，当窗口内需要替换的数量<k时，窗口可以向后移动；>=k时，向左移动
    def characterReplacement(s: String, k: Int): Int = {
        val count = new Array[Int](256)
        def isValid(): Boolean = count.sum - count.max <= k
        var res = 1
        var l = 0
        for (r <- 0 until s.length) {
            count(s(r)) += 1
            while (!isValid()) {
                count(s(l)) -= 1
                l += 1
            }
            res = res.max(r - l + 1)
        }
        res
    }
}