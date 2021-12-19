object L25 {

  def main(args: Array[String]): Unit = {
    reverseKGroup(ListNode.of(Array(1, 2, 3, 4, 5)), 2).printListNode()
  }

  /**
   * 可以分成两部分 1. cut链表  2.链表翻转
   */
  def reverseKGroup(head: ListNode, k: Int): ListNode = {
    val dummy = new ListNode
    var pre = dummy
    var cur = head
    while (cur != null) {
      val tuple = cut(cur, k)
      if (tuple._1) {
        pre.next = reverse(cur)
        pre = cur
        cur = tuple._2
      } else {
        pre.next = cur
        cur = null
      }
    }
    dummy.next
  }

  /**
   * use ${length} to cut the list into two part
   */
  private def cut(head: ListNode, _length: Int): (Boolean, ListNode) = {
    assert(head != null && _length > 0)
    val dummy = new ListNode
    dummy.next = head
    var cur = dummy
    var length = _length
    while (cur != null && length > 0) {
      cur = cur.next
      length -= 1
    }
    if (cur == null) {
      // insufficient length
      (false, null)
    } else {
      val remain = cur.next
      cur.next = null
      (true, remain)
    }
  }

  private def reverse(head: ListNode): ListNode = {
    var pre: ListNode = null
    var cur = head
    while (cur != null) {
      val next = cur.next
      cur.next = pre
      pre = cur
      // continue
      cur = next
    }
    pre
  }
}