object L19 {

  def main(args: Array[String]): Unit = {
    removeNthFromEnd(ListNode.of(Array(1, 2, 3, 4, 5)), 2).printListNode()
    removeNthFromEnd(ListNode.of(Array(1, 2, 3, 4, 5)), 5).printListNode()
    println(removeNthFromEnd(ListNode.of(Array(1)), 1))
  }
  // 画图 + 双指针 
  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    val dummy = new ListNode()
    dummy.next = head
    var slow, fast = dummy
    for (i <- 0 until n) {
      fast = fast.next
    }
    while (fast.next != null) {
      fast = fast.next
      slow = slow.next
    }
    slow.next = slow.next.next
    dummy.next
  }
}
