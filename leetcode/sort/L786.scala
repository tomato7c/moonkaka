object Solution {
    // 多路归并 eg[1,2,3,5]
    // (1, (5,3,2))
    // (2, (5, 3))
    // (3, (5))
    def kthSmallestPrimeFraction(arr: Array[Int], k: Int): Array[Int] = {
        val minHeap = collection.mutable.PriorityQueue[(Double, Int, Int)]()(Ordering.by(_._1)).reverse // value, i, j 存储double值与索引
        val n = arr.length
        // 枚举分子
        for (i <- 0 until math.min(n - 1, k)) minHeap.enqueue((arr(i)*1.0 / arr(n - 1)*1.0, i, n - 1))

        for (temp <- 1 to k - 1) { // 去掉前k - 1个最小元素, 并加入候选元素
            val (_, i, j) = minHeap.dequeue
            if (j - 1 > i) minHeap.enqueue((arr(i)*1.0 / arr(j-1)*1.0, i, j - 1))
        }
        val (_, i, j) = minHeap.dequeue
        Array(arr(i), arr(j))
    }
}