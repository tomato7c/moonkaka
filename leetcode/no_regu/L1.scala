// map
object L1 {
  def main(args: Array[String]): Unit = {
    var arr = Array(2, 7, 11, 15)
    var possibleSolutions = Array((0, 1), (1, 0))
    var res = twoSum1(arr, 9)
    var bool = possibleSolutions exists (x => x._1 == res(0) && x._2 == res(1) || x._1 == res(1) && x._2 == res(0))
    assert(bool)

    arr = Array(1, 1)
    possibleSolutions = Array((1, 0), (0, 1))
    res = twoSum(arr, 2)
    bool = possibleSolutions exists (x => x._1 == res(0) && x._2 == res(1) || x._1 == res(1) && x._2 == res(0))
    assert(bool)
  }
  // 如果不要求返回index, 完全可以用set
  def twoSum(arr: Array[Int], target: Int): Array[Int] = {
    var map = collection.mutable.Map[Int, Int]()
    for (i <- arr.indices) {
      val diff = target - arr(i)
      if (map.contains(diff)) return Array(i, map(diff))
      map += (arr(i) -> i)
    }
    throw new Exception("no answer")
  }

  // pattern match版
  def twoSum1(arr: Array[Int], target: Int): Array[Int] = {
    var map: Map[Int, Int] = Map()
    for (i <- arr.indices) {
      val diff = target - arr(i)
      map.get(diff) match {
        case Some(v) => return Array(i, v)
        case _ => map += (arr(i) -> i)
      }
    }
    throw new Exception("no answer")
  }
}

