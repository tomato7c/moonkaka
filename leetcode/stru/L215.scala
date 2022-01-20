object L215 {
    def findKthLargest(arr: Array[Int], k: Int): Int = {
        val q = collection.mutable.PriorityQueue[Int]()(Ordering.by(_ * -1))
        for (v <- arr) {
            if (q.size < k) {
                q.enqueue(v)
            } else if (q.head < v) {
                q.dequeue()
                q.enqueue(v)
            }
        }
        q.head
    }
}
