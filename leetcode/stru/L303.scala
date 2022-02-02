class NumArray(_nums: Array[Int]) {

    val n = _nums.length
    val prefix = new Array[Int](n)

    {
        prefix(0) = _nums(0)
        for (i <- 1 until n) prefix(i) = prefix(i - 1) + _nums(i)
    }

    def sumRange(left: Int, right: Int): Int = {
        prefix(right) - safeIndex(prefix, left - 1)
    }

    private def safeIndex(arr: Array[Int], index: Int): Int = if (index < 0) 0 else arr(index)

}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = new NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */