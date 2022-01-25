object Solution {
    // 维护队首索引值，并维护队列单调递减性质
    def maxSlidingWindow(arr: Array[Int], k: Int): Array[Int] = {
        val q = new java.util.LinkedList[Int]()
        val res = collection.mutable.ListBuffer[Int]()
        for (i <- arr.indices) {
            while (!q.isEmpty && arr(q.peekLast) <= arr(i)) q.pollLast // 维护单调性
            q.offer(i)
            if (i >= k && q.peekFirst <= i - k) q.pollFirst // 维护窗口
            if (i >= k - 1) res += arr(q.peekFirst)
        }
        res.toArray
    }
}
