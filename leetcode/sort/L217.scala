object L217 {
    def containsDuplicate(nums: Array[Int]): Boolean = {
        val arr = nums.sortWith(_<_)
        for (i <- 0 until arr.length - 1) {
            if (arr(i) == arr(i + 1)) return true
        }
        false
    }
}
