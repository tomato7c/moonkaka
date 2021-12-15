import scala.util.control.Breaks.{break, breakable}
object L15 {

  def main(args: Array[String]): Unit = {
    println(threeSum(Array(-1, 0, 1, 2, -1, -4)))
    println(threeSum(Array()))
    println(threeSum(Array(0)))
  }

  // 排序，因为三元组不能有重复，需要在迭代过程中跳过值相等的情况(如何避免重复？a, b, c均取第一个值，移动方向上有重复就跳过)；按a迭代，双指针找到c + d (本质是排除法)
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val arr = nums.sortWith(_<_)
    val res = collection.mutable.ListBuffer[List[Int]]()

    for (i <- arr.indices) {
      breakable({
        if (i - 1 >= 0 && arr(i) == arr(i - 1)) break
        var l = i + 1
        var r = arr.length - 1
        while (l < r) {
          val sum = arr(i) + arr(l) + arr(r)
          if (sum == 0) {
            res.addOne(List(arr(i), arr(l), arr(r)))
            while (l + 1 < r && arr(l) == arr(l + 1)) l += 1
            while (l < r - 1 && arr(r) == arr(r - 1)) r -= 1
            l += 1
            r -= 1
          } else if (sum > 0) {
            r -= 1
          } else {
            l += 1
          }
        }
      })
    }
    res.toList
  }
}