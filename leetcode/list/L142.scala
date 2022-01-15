object L142 {
    def detectCycle_v1(head: ListNode): ListNode = {
        val set = collection.mutable.Set[ListNode]()
        var cur = head
        while (cur != null) {
            if (set.contains(cur)) return cur
            set += cur
            cur = cur.next
        }
        null
    }
    // 构造第二次相遇
    // 假设慢指针走x + y步与快指针相遇；则快指针走x + nk + y = 2x + 2y => x = nk - y； 若快指针再走x步 => x + nk + y + nk - y = x + nk,回到环入口
    def detectCycle_v2(head: ListNode): ListNode = {
        if (head == null || head.next == null) return null
        var slow, fast = head
        breakable({
            while (fast != null && fast.next != null) {
                fast = fast.next.next
                slow = slow.next
                if (fast == slow) break
            }
        })
        if (fast != slow) return null
        slow = head
        while (slow != fast) {
            slow = slow.next
            fast = fast.next
        }
        fast
    }
}