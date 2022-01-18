object L219 {
    // 类似滑动窗口，可以把空间复杂度优化到O(k)
    def containsNearbyDuplicate(arr: Array[Int], k: Int): Boolean = {
        val set = collection.mutable.Set[Int]()
        for (i <- arr.indices) {
            if (set.contains(arr(i))) return true

            set += arr(i)
            if (set.size > k) set -= arr(i - k)
        }
        false
    }
}