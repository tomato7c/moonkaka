object Solution {
    def integerReplacement(n: Int): Int = {
        val q = collection.mutable.Queue[Long]()
        var step = 0
        q.enqueue(n.toLong)
        while (q.nonEmpty) {
            val size = q.size
            for (temp <- 1 to size) {
                val cur = q.dequeue
                if (cur == 1) return step
                if (cur % 2 == 0) {
                    q.enqueue(cur / 2)
                } else {
                    q.enqueue(cur + 1)
                    q.enqueue(cur - 1)
                }
            }
            step += 1
        }
        -1
    }
}