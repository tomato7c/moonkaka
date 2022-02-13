import scala.util.Random
class Solution(_nums: Array[Int]) {

    def pick(target: Int): Int = {
        var res = -1
        var count = 0
        for ((v, i) <- _nums.zipWithIndex if v == target) {
            count += 1
            val rate = Random.nextInt(count)
            if (rate == 0) res = i
        }
        res
    }  

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(nums)
 * var param_1 = obj.pick(target)
 */