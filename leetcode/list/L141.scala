object L141 {
    def hasCycle_v1(head: ListNode): Boolean = {
        val set = collection.mutable.Set[ListNode]()
        var cur = head
        while (cur != null) {
            if (set.contains(cur)) {
                return true
            } else {
                set += cur
                cur = cur.next
            }
        }
        false
    }
    def hasCycle_v2(head: ListNode): Boolean = {
        var slow = head; var fast = head
        while (fast != null && fast.next != null) {
            slow = slow.next
            fast = fast.next.next
            if (slow == fast) return true
        }
        false
    }
}