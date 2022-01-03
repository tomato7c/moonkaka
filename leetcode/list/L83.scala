object Solution {
	// pre维护结果集末尾
    def deleteDuplicates(head: ListNode): ListNode = {
        var pre = head; var cur = head
        while (cur != null) {
            while (cur != null && cur.x == pre.x) cur = cur.next
            pre.next = cur
            pre = pre.next
        }
        head
    }
}