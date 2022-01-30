object Solution {
    // nums异或的结果为 a ^ b的值
    // 假设 a ^ b 的第k位是1，则表明a，b的第k位一个是1，一个是0； 可以把整个数组按照第k位是否1来分组，两个组分别异或的结果就是a,b值
    def singleNumber(nums: Array[Int]): Array[Int] = {
        var xor = 0
        for (v <- nums) xor ^= v
        var k = 0
        while ((xor & 1) == 0) {
            k += 1
            xor >>= 1
        }
        Array(get(nums, k, 1), get(nums, k, 0))
    }

    private def get(nums: Array[Int], k: Int, bool: Int): Int = {
        var res = 0
        for (v <- nums if ((v >> k) & 1) == bool) res ^= v
        res
    }
}