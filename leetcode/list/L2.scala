// two indices
object L2 {

  def main(args: Array[String]): Unit = {
    var first = ListNode.of(Array(1, 2, 3))
    var second = ListNode.of(Array(2, 2, 2))
    addTwoNumbers(first, second).assertEquals(ListNode.of(Array(3, 4, 5)))

    first = ListNode.of(Array(9, 9, 1))
    second = ListNode.of(Array(5, 9, 9))
    addTwoNumbers(first, second).assertEquals(ListNode.of(Array(4, 9, 1, 1)))

    first = ListNode.of(Array(0))
    second = ListNode.of(Array(0))
    addTwoNumbers(first, second).assertEquals(ListNode.of(Array(0)))
  }

  // 循环不变式中维护进位标志，进位数(可省略，因为全部是1); 循环后特殊处理
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var a = l1
    var b = l2
    val dummy = new ListNode()
    var pre = dummy
    var carry = false

    while (a != null && b != null) {
      // compute state
      val sum = a.x + b.x + (if (carry) 1 else 0)
      val mod = sum % 10
      carry = sum != mod // reset carry flag
      pre.next = new ListNode(mod) // define current node
      pre = pre.next

      // continue
      a = a.next
      b = b.next
    }
    while (a != null) {
      // compute state
      val sum = a.x + (if (carry) 1 else 0)
      val mod = sum % 10
      carry = sum != mod // reset carry flag
      pre.next = new ListNode(mod) // define current node
      pre = pre.next

      // continue
      a = a.next
    }

    while (b != null) {
      // compute state
      val sum = b.x + (if (carry) 1 else 0)
      val mod = sum % 10
      carry = sum != mod // reset carry flag
      pre.next = new ListNode(mod) // define current node
      pre = pre.next

      // continue
      b = b.next
    }

    if (carry) {
      pre.next = new ListNode(1)
    }
    dummy.next
  }
}