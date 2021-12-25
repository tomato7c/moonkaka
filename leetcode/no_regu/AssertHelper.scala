object AssertHelper {

  def assertEquals(a: Array[Int], b: Array[Int]): Unit = {
    assert(a != null && b != null)
    assert(a.length == b.length)
    for (i <- a.indices) {
      assert(a(i) == b(i))
    }
  }
}