
object L41 {
    // 答案肯定在[1, arr.length + 1]之间；基数排序
    def firstMissingPositive(arr: Array[Int]): Int = {
        val set = arr.toSet
        for (v <- 1 to arr.length + 1) {
            if (!set.contains(v)) return v
        }
        return -1
    }

        // 常量空间，把v映射到arr(v - 1) (如果可以的话)
    // 找出第一个 arr(i) != i + 1
    def firstMissingPositiveV2(arr: Array[Int]): Int = {
        for (i <- arr.indices) {
            while (arr(i) <= arr.length && arr(i)> 0 && arr(arr(i) - 1) != arr(i)) swap(arr, i, arr(i) - 1)
        }
        for (i <- arr.indices) {
            if (arr(i) != i + 1) return i + 1
        }
        return arr.length + 1
    }

    private def swap(arr: Array[Int], a: Int, b: Int) {
        val temp = arr(a)
        arr(a) = arr(b)
        arr(b) = temp
    }
}