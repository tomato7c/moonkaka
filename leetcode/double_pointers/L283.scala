object Solution {
    // 双指针swap
    // i遇到0, j向后找到第一个非0与它交换
    def moveZeroes(arr: Array[Int]): Unit = {
        var j = 0
        for (i <- arr.indices if arr(i) == 0) {
            j = j.max(i + 1)
            while (j < arr.length && arr(j) == 0) j += 1
            if (j < arr.length) swap(arr, i, j)
        }
    }

    private def swap(arr: Array[Int], a: Int, b: Int) {
        val temp = arr(a)
        arr(a) = arr(b)
        arr(b) = temp
    }
}