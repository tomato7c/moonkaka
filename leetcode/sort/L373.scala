import scala.collection.mutable
object Solution {
    // 解空间是一个每行、每列递增有序的数组,可以用多路归并，每次获取解时，最小值一定在堆上
    def kSmallestPairs(arr1: Array[Int], arr2: Array[Int], k: Int): List[List[Int]] = {
        val res = mutable.ListBuffer[List[Int]]()
        val minHeap = mutable.PriorityQueue[(Int, Int, Int)]()(Ordering.by(_._1)).reverse // (sum, i, j)
        val m = arr1.length; val n = arr2.length
        for (i <- 0 until math.min(m, k)) minHeap.enqueue((arr1(i) + arr2(0), i, 0))
        // 可能不足k个
        while (res.size < k && minHeap.nonEmpty) {
            val (_, i, j) = minHeap.dequeue
            res += List(arr1(i), arr2(j))
            if (j + 1 < n) minHeap.enqueue((arr1(i) + arr2(j + 1), i, j + 1)) // 该行下一个元素放到堆里
        }
        res.toList
    }
}