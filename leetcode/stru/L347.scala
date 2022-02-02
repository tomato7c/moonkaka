object Solution {
    def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {
        val map = collection.mutable.Map[Int, Int]()
        for (v <- nums) map += (v -> (map.getOrElse(v, 0) + 1))
        val q = collection.mutable.PriorityQueue[Int]()(Ordering.by(map(_)))

        for (key <- map.keys) q.enqueue(key)

        val res = new Array[Int](k)
        var index = 0
        while (index < k) {
            res(index) = q.dequeue
            index += 1
        }
        res
    }
}