object L109 {
    // 转成数组比较简便了，跟108题一样；另一种节省空间(增加时间)的方式是，通过快慢指针获取链表中点、
    // 1,2,3    1,2,3,4
    def sortedListToBST(head: ListNode): TreeNode = {
        dfs(head, null)
    }

    def dfs(start: ListNode, end: ListNode): TreeNode = {
        if (start == end) return null
        if (start.next == end) return new TreeNode(start.x)

        val mid = midNode(start, end)
        val root = new TreeNode(mid.x)
        root.left = dfs(start, mid)
        root.right = dfs(mid.next, end)
        root
    }

    def midNode(head: ListNode, end: ListNode): ListNode = {
        var slow = head; var fast = head
        while (fast != end && fast.next != end) {
            slow = slow.next
            fast = fast.next.next
        }
        slow
    }
}