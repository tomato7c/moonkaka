object Solution {
    // arr(i)映射到 index:arr(i) - 1
    def findDuplicates(arr: Array[Int]): List[Int] = {
        val res = collection.mutable.ListBuffer[Int]()

        for (i <- arr.indices) {
            while (arr(arr(i) - 1) != arr(i)) swap(arr, i, arr(i) - 1)
        }
        for (i <- arr.indices if arr(i) != i + 1) res += arr(i)
        res.toList
    }

    private def swap(arr: Array[Int], a: Int, b: Int) {
        val temp = arr(a)
        arr(a) = arr(b)
        arr(b) = temp
    }
}