object Solution {

    // 由于是查找右侧小于当前元素个数，树状数组query时需要从后往前迭代
    def countSmaller(_nums: Array[Int]): List[Int] = {
        // 将[-10000,10000]映射到[1,20001]
        val nums = for (v <- _nums) yield v + 10001
        val res = collection.mutable.ListBuffer[Int]()
        val tree = new BinaryIndexTree(20001) // [1,20001] -> 20001个数
        for (i <- nums.indices.reverse) {
            val v = nums(i)
            res += tree.query(v - 1)
            tree.add(v, 1)
        }
        res.reverse.toList
    }
    // 下标最多到n
    class BinaryIndexTree(n: Int) {

        val arr = new Array[Int](n + 1)

        def lowbit(x: Int): Int = x & -x

        def add(_x: Int, v: Int) {
            var x = _x
            while (x <= arr.length - 1) {
                arr(x) += v
                x += lowbit(x)
            }
        }
        // (-, x]个数
        def query(_x: Int): Int = {
            var res = 0
            var x = _x
            while (x >= 1) {
                res += arr(x)
                x -= lowbit(x)
            }
            res
        }
    }
}