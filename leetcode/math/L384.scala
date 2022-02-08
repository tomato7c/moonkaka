import scala.util.Random
class Solution(_nums: Array[Int]) {
    val origin = _nums
    val arr = new Array[Int](origin.length)
    for (i <- origin.indices) arr(i) = origin(i)

    def reset(): Array[Int] = {
        origin
    }
    // 1,2,3,4
    def shuffle(): Array[Int] = {
        for (i <- arr.indices) {
            swap(arr, i, Random.nextInt(arr.length - i) + i)
        }
        arr
    }

    private def swap(arr: Array[Int], a: Int, b: Int) {
        val temp = arr(a)
        arr(a) = arr(b)
        arr(b) = temp
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(nums)
 * var param_1 = obj.reset()
 * var param_2 = obj.shuffle()
 */