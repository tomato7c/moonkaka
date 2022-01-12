object L134 {
  // 画图理解，任何一点剩余汽油量都要>= 0
  def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
    val n = gas.length
    var remain = 0
    var minIndex = 0
    var min = Int.MaxValue
    for (i <- 0 until n) {
        remain += gas(i) - cost(i)
        if (remain < min) {
            min = remain
            minIndex = i
        }
    }
    if (remain < 0) - 1 else (minIndex + 1) % n
  }
}