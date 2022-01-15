object L143 {
    // 快慢指针找中点，翻转后半部分再merge
    def reorderList(head: ListNode): Unit = {
        if (head == null || head.next == null) return
        var slow, fast = head
        var pre: ListNode = null
        while (fast != null && fast.next != null) {
            fast = fast.next.next
            pre = slow
            slow = slow.next
        }
        var p = head; var q: ListNode = null
        q = reverse(slow.next)
        slow.next = null
        // merge
        merge(p, q)
    }

    private def merge(a: ListNode, b: ListNode) {
        var dummy = new ListNode
        var i = 0
        var p = a; var q = b
        var pre = dummy
        while (p != null && q != null) {
            if (i % 2 == 0) {
                pre.next = p
                p = p.next
            } else {
                pre.next = q
                q = q.next
            }
            pre = pre.next
            i += 1
        }
        if (p != null) pre.next = p
        if (q != null) pre.next = q
    }

    private def reverse(head: ListNode): ListNode = {
        var cur = head; var pre: ListNode = null
        while (cur != null) {
            val next = cur.next
            cur.next = pre
            pre = cur
            cur = next
        }
        pre
    }
}