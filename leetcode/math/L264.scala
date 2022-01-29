object Solution {
    // 1是最小的丑数
    // 2,3,5 -> 2x, 3x, 5x是丑数
    // 用PriorityQueue获取第n个丑数; 每次循环，dequeue一个丑数(所以只需要循环n - 1次)
    def nthUglyNumber(n: Int): Int = {
        val set = collection.mutable.Set[Long]()
        val q = collection.mutable.PriorityQueue[Long]().reverse
        q.enqueue(1)
        set += 1
        for (i <- 1 to n - 1) {
            val v = q.dequeue
            if (!set.contains(2 * v)) {
                q.enqueue(2 * v)
                set += 2 * v
            } 
            if (!set.contains(3 * v)) {
                q.enqueue(3 * v)
                set += 3 * v
            }
            if (!set.contains(5 * v)) {
                q.enqueue(5 * v)
                set += 5 * v
            }
        }
        q.head.toInt
    }
}