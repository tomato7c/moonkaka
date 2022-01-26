object Solution {
    // 每个数放到索引 i - 1位置，存在重复则返回结果
    def findDuplicate(arr: Array[Int]): Int = {
        for (i <- arr.indices) {
            while (arr(i) != i + 1) {
                if (arr(arr(i) - 1) == arr(i)) return arr(i)
                swap(arr, arr(i) - 1, i)
            }
        }
        -1
    }

    private def swap(arr: Array[Int], a: Int, b: Int): Unit = {
        val temp = arr(a)
        arr(a) = arr(b)
        arr(b) = temp
    }
}
