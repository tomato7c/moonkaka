object L26 {

  def main(args: Array[String]): Unit = {
    println(removeDuplicates(Array(0,0,1,1,1,2,2,3,3,4)))
    println(removeDuplicates(Array()))
    println(removeDuplicates(Array(1, 1, 1, 1, 1)))
    println(removeDuplicates(Array(1, 2, 3, 4, 5)))
  }

  /**
   * 既然是排序的，利用双指针，a指向结果集末尾，b向右移动
   */
  def removeDuplicates(arr: Array[Int]): Int = {
    if (arr.length < 1) return 0
    var a = 0
    var b = 1
    while (b < arr.length) {
      if (arr(b) != arr(a)) {
        a += 1
        arr(a) = arr(b)
      }
      b += 1
    }
    a + 1
  }
}