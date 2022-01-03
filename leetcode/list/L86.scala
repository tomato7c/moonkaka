object L86 {
    def partition(head: ListNode, x: Int): ListNode = {
        val dummyA = new ListNode; var a = dummyA
        val dummyB = new ListNode; var b = dummyB
        var cur = head
        while (cur != null) {
            if (cur.x < x) {
                a.next = cur
                a = a.next
            } else {
                b.next = cur
                b = b.next
            }
            cur = cur.next
        }
        b.next = null
        a.next = dummyB.next
        dummyA.next
    }
}