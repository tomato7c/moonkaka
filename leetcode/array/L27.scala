object L27 {

  def main(args: Array[String]): Unit = {
    assert(removeElement(Array(0,1,2,2,3,0,4,2), 2) == 5)
    assert(removeElement(Array(0, 0, 0), 0) == 0)
    assert(removeElement(Array(1), 0) == 1)
  }

  // 单次枚举就行~
  def removeElement(arr: Array[Int], value: Int): Int = {
    var a = -1
    for (v <- arr if v != value) {
      a += 1
      arr(a) = v
    }
    a + 1
  }
}