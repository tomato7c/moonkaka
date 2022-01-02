object L82 {
    def deleteDuplicates(head: ListNode): ListNode = {
        val dummy = new ListNode; dummy.next = head
        var pre = dummy; var cur = head
        while (cur != null) {
            if (cur.next != null && cur.x == cur.next.x) {
                val x = cur.x
                while (cur != null && cur.x == x) cur = cur.next
            } else {
                pre.next = cur
                pre = pre.next
                cur = cur.next
            }
        }
        pre.next = null
        dummy.next
    }
}