/**
 * Definition for a Node.
 * class Node(var _value: Int) {
 *   var value: Int = _value
 *   var children: List[Node] = List()
 * }
 */

object Solution {
    def levelOrder(root: Node): List[List[Int]] = {
        val res = collection.mutable.ListBuffer[List[Int]]()
        val q = collection.mutable.Queue[Node]()
        if (root == null) return res.toList
        q.enqueue(root)
        
        while (q.nonEmpty) {
            val size = q.size
            val subList = collection.mutable.ListBuffer[Int]()
            for (temp <- 0 until size) {
                val cur = q.dequeue
                subList += cur.value
                for (c <- cur.children) {
                    q.enqueue(c)
                }
            }
            res += subList.toList
        }
        res.toList
    }
}