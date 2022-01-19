object L203 {
    def removeElements(head: ListNode, value: Int): ListNode = {
        val dummy = new ListNode
        dummy.next = head
        var cur = dummy
        while (cur != null) {
            var next = cur.next
            while (next != null && next.x == value) next = next.next
            cur.next = next
            cur = cur.next
        }
        dummy.next
    }
}