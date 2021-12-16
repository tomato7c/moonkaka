object L21 {

  def main(args: Array[String]): Unit = {
    mergeTwoLists(ListNode.of(Array(1, 2, 4)), ListNode.of(Array(1, 3, 4))).printListNode()
    println(mergeTwoLists(null, null))
    mergeTwoLists(null, ListNode.of(Array(0))).printListNode()
  }

  // 双指针
  def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
    val dummy = new ListNode()
    var pointer = dummy
    var a = list1
    var b = list2
    while (a != null && b != null) {
      if (a.x <= b.x) {
        pointer.next = a
        pointer = pointer.next
        a = a.next
      } else {
        pointer.next = b
        pointer = pointer.next
        b = b.next
      }
    }
    if (a != null) pointer.next = a
    if (b != null) pointer.next = b

    dummy.next
  }
}