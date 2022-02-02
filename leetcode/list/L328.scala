/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def oddEvenList(head: ListNode): ListNode = {
        val oddDummy = new ListNode; var oddTail = oddDummy
        val evenDummy = new ListNode; var evenTail = evenDummy
        var count = 1
        var cur = head
        while (cur != null) {
            if ((count & 1) == 1) {
                oddTail.next = cur
                oddTail = oddTail.next
            } else {
                evenTail.next = cur
                evenTail = evenTail.next
            }
            cur = cur.next
            count += 1
        }

        oddTail.next = evenDummy.next
        evenTail.next = null

        oddDummy.next
    }
}