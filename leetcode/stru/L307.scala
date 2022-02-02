class NumArray(_nums: Array[Int]) {
  val tree = new BinaryIndexTree(_nums.length + 1)

  {
    for (i <- _nums.indices) tree.add(i + 1, _nums(i))
  }

  def update(index: Int, value: Int): Unit = {
    tree.add(index + 1, value - _nums(index))
    _nums(index) = value
  }

  def sumRange(left: Int, right: Int): Int = {
    tree.query(right + 1) - tree.query(left)
  }


  class BinaryIndexTree(_n: Int) {
    val arr = new Array[Int](_n + 1)

    private def lowbit(x: Int): Int = x & -x

    def add(_index: Int, k: Int) {
      var index = _index
      while (index < arr.length - 1) {
        arr(index) += k
        index += lowbit(index)
      }
    }

    def query(_x: Int): Int = {
      var index = _x
      var res = 0
      while (index >= 1) {
        res += arr(index)
        index -= lowbit(index)
      }
      res
    }
  }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = new NumArray(nums)
 * obj.update(index,`val`)
 * var param_2 = obj.sumRange(left,right)
 */