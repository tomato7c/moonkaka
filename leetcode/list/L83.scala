object L83 {

  def main(args: Array[String]): Unit = {
    deleteDuplicates(ListNode.of(Array(0, 0, 1, 1, 1, 5))).printListNode()
  }

  // 双指针，i维护结果集末尾, j向后移动
  def deleteDuplicates(head: ListNode): ListNode = {
    val dummy = new ListNode()
    dummy.next = head
    var p = dummy
    var q = head
    while (q != null) {
      if (p.x != q.x || p == dummy) {
        p.next = q
        p = p.next
      }
      q = q.next
    }
    p.next = null
    dummy.next
  }
}