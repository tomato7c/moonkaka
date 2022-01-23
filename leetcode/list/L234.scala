/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object L234 {
    def isPalindrome(head: ListNode): Boolean = {
        var fast, slow = head
        while (fast != null && fast.next != null) {
            slow = slow.next
            fast = fast.next.next
        }
        if (fast != null) slow = slow.next // 奇数情况下，slow后移一位
        var p = reverse(slow); var q = head
        while (p != null) {
            if (p.x != q.x) return false
            p = p.next
            q = q.next
        }
        true
    }

    private def reverse(head: ListNode): ListNode = {
        var newHead: ListNode = null; var cur = head
        while (cur != null) {
            val next = cur.next
            cur.next = newHead
            newHead = cur
            cur = next
        }
        newHead
    }
}