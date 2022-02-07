import scala.util.control.Breaks.{break, breakable}
object Solution {
    // 满足不存在aaa条件的情况下选剩余最多的，否则选择剩余次多的
    def longestDiverseString(a: Int, b: Int, c: Int): String = {
        val maxHeap = collection.mutable.PriorityQueue[(Char, Int)]()(Ordering.by(_._2))
        if (a > 0) maxHeap.enqueue(('a', a))
        if (b > 0) maxHeap.enqueue(('b', b))
        if (c > 0) maxHeap.enqueue(('c', c))

        val res = new StringBuilder
        breakable({
            while (maxHeap.nonEmpty) {
                val first = maxHeap.dequeue
                var candidate = first
                if (res.size >= 2 && res.last == candidate._1 && res(res.length - 2) == candidate._1) {
                    if (maxHeap.isEmpty) break
                    candidate = maxHeap.dequeue
                    maxHeap.enqueue(first)
                }
                val (c, count) = candidate
                res.append(c)
                if (count - 1 > 0) maxHeap.enqueue((c, count - 1))
            }
        })
        res.toString
    }
}