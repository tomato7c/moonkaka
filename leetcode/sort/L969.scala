object Solution {
    // 每次保证最大值翻转到待排序部分末尾
    def pancakeSort(arr: Array[Int]): List[Int] = {
        def reverse(end: Int) {
            var l = 0; var r = end
            while (l < r) {
                val temp = arr(l)
                arr(l) = arr(r)
                arr(r) = temp
                l += 1; r -= 1
            }
        }
        val res = collection.mutable.ListBuffer[Int]()
        for (i <- arr.indices.reverse if (arr(i)) != i + 1) {
            var j = 0
            while (arr(j) != i + 1) j += 1 // 找到i位置应该放置的元素
            if (j != 0) {
                res += j
                reverse(j)
            }
            res += i
            reverse(i)
        }
        res.map(_ + 1).toList
    }
}