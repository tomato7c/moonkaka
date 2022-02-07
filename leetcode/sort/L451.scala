object Solution {
    // Priority多个排序策略用法
    def frequencySort(s: String): String = {
        val maxHeap = collection.mutable.PriorityQueue[(Char, Int)]()(Ordering
        .by[(Char, Int), Int](_._2)
        .orElseBy[Int](-_._1))
        val freq = new Array[Int](256)
        for (c <- s) freq(c) += 1

        for ((count, i) <- freq.zipWithIndex if count > 0) maxHeap.enqueue((i.toChar, count))

        val res = new StringBuilder
        while (maxHeap.nonEmpty) {
            val (c, count) = maxHeap.dequeue
            res.append(s"$c" * count)
        }
        res.toString
    }
}