object L88 {
    // 沃日，原来可以从末尾开始...
    def merge(nums1: Array[Int], _m: Int, nums2: Array[Int], _n: Int): Unit = {
        var index = nums1.length
        var m = _m - 1
        var n = _n - 1
        while (m >= 0 && n >= 0) {
            if (nums1(m) >= nums2(n)) {
                index -= 1
                nums1(index) = nums1(m)
                m -= 1
            } else {
                index -= 1
                nums1(index) = nums2(n)
                n -= 1
            }
        }
        while (n >= 0) {
            index -= 1
            nums1(index) = nums2(n)
            n -= 1
        }
    }
}