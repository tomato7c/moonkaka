object L4 {

  def main(args: Array[String]): Unit = {
    println(findMedianSortedArrays(Array(1, 2), Array(3, 4)))
    println(findMedianSortedArrays(Array(1, 3), Array(2)))
    println(findMedianSortedArrays(Array(0, 0), Array(0, 0)))
    println(findMedianSortedArrays(Array(1), Array()))
    println(findMedianSortedArrays(Array(), Array(2)))
  }
  // 双指针，根据奇偶数选择不同分支，主要是拿到中间的a 和 (b)
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    if (nums1.length == 0 && nums2.length == 0) throw new Exception("no answer")

    var a, b = 0
    var head, tail: Int = Int.MinValue // 模拟队列
    val mid = (nums1.length + nums2.length) / 2
    val isOdd = (nums1.length + nums2.length) % 2 == 1
    while ((a + b) != mid + 1) {
      val next = Math.min(safeApply(nums1, a), safeApply(nums2, b))
      if (next == safeApply(nums1, a)) a += 1 else b += 1
      head = tail
      tail = next
    }
    if (isOdd) tail else (head + tail) / 2.0
  }

  def safeApply(arr: Array[Int], index: Int): Int = {
    if (index < arr.length) arr(index) else Int.MaxValue
  }
}
