object L160 {
    // 假设相交链表结构中分为a,b,c三段 p指针都a + c + b, q指针走 b + c + a，如果最后指向相等，则相交
    def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
        var p = headA; var q = headB
        while (p != q) {
            p = if (p == null) headB else p.next
            q = if (q == null) headA else q.next
        }
        p
    }
}