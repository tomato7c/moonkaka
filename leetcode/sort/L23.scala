/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def mergeKLists(lists: Array[ListNode]): ListNode = {
        val minHeap = collection.mutable.PriorityQueue[ListNode]()(Ordering.by(_.x)).reverse

        val dummy = new ListNode
        var cur = dummy
        for (node <- lists if node != null) minHeap.enqueue(node)
        while (minHeap.nonEmpty) {
            val node = minHeap.dequeue
            cur.next = node
            cur = cur.next
            if (node.next != null) minHeap.enqueue(node.next)
        }
        cur.next = null
        dummy.next
    }
}