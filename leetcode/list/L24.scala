object L24 {

  def main(args: Array[String]): Unit = {
    swapPairs(ListNode.of(Array(1, 2, 3, 4))).printListNode()
    swapPairs(ListNode.of(Array(1))).printListNode()
    swapPairs(ListNode.of(Array(1, 2, 3))).printListNode()
  }

  /**
   * 循环不变式, a和a.next都不是Null, 才会做交换; 维护pre指针，维持连接
   */
  def swapPairs(head: ListNode): ListNode = {
    val dummy = new ListNode()
    var pre = dummy
    var a = head
    while (a != null && a.next != null) {
      val b = a.next
      val next = b.next
      pre.next = b
      b.next = a
      // continue
      pre = a
      a.next = next
      a = next
    }
    if (a != null) pre.next = a
    dummy.next
  }
}