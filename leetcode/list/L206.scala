object L206 {
    def reverseList(head: ListNode): ListNode = {
        var pre: ListNode = null
        var cur = head
        while (cur != null) {
            val next = cur.next
            cur.next = pre
            pre = cur
            cur = next
        }
        pre
    }
}