object L80 {
    // 更一般的解法，判断当前值是否保留的条件是，是否与当前位置左边第k个数相同
    def removeDuplicates(arr: Array[Int]): Int = {
        removeDuplicates(arr, 2)
    }

    private def removeDuplicates(arr: Array[Int], k: Int): Int = {
        var index = -1
        for (v <- arr) {
            if (index + 1 < k || arr(index + 1 - k) != v) {
                index += 1
                arr(index) = v
            }
        }
        index + 1
    }
}