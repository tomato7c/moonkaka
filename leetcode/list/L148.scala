object L148 {
    // cut and merge
    def sortList(head: ListNode): ListNode = {
        val size = sizeOf(head)
        var subSize = 1
        val dummy = new ListNode
        dummy.next = head
        while (subSize < size) {
            var cur = dummy.next; var tail = dummy
            while (cur != null) {
                val left = cur
                val right = cut(left, subSize)
                cur = cut(right, subSize)
                tail.next = merge(left, right)
                
                while (tail.next != null) tail = tail.next
            }

            subSize *= 2
        }
        dummy.next
    }

    // cut first half by size and return the second half
    private def cut(head: ListNode, size: Int): ListNode = {
        var cur = head
        var count = 1
        while (count < size && cur != null) {
            count += 1
            cur = cur.next
        }
        if (cur == null) return null

        val res = cur.next
        cur.next = null
        res
    }

    private def merge(_p: ListNode, _q: ListNode): ListNode = {
        val dummy = new ListNode
        var cur = dummy; var p = _p; var q = _q
        while (p != null && q != null) {
            if (p.x <= q.x) {
                cur.next = p
                p = p.next
            } else {
                cur.next = q
                q = q.next
            }
            cur = cur.next
        }
        if (p != null) cur.next = p
        if (q != null) cur.next = q
        dummy.next
    }

    private def sizeOf(head: ListNode): Int = {
        var cur = head; var res = 0
        while (cur != null) {
            res += 1
            cur = cur.next
        }
        res
    }
}