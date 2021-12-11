class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x

  def printListNode(): Unit = {
    printListNode(this)
  }

  private def printListNode(node: ListNode): Unit = {
    if (node == null) return
    print(s"${node.x} ")
    printListNode(node.next)
  }

  def assertEquals(target: ListNode): Unit = {
    assert(target != null)
    var a = this
    var b = target

    while (a != null && b != null) {
      assert(a.x == b.x)
      a = a.next
      b = b.next
    }
    assert(a == null && b == null)
  }
}

object ListNode {
  def of(arr: Array[Int]): ListNode = {
    assert(!arr.isEmpty)

    val dummy: ListNode = new ListNode()
    var curr = dummy
    arr.foreach(it => {
      val node = new ListNode(it)
      curr.next = node
      curr = curr.next
    })

    dummy.next
  }
}