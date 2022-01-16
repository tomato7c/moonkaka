object L167 {
    def twoSum(arr: Array[Int], target: Int): Array[Int] = {
        var l = 0; var r = arr.length - 1
        while (l < r) {
            val sum = arr(l) + arr(r)
            if (sum == target) {
                return Array(l + 1, r + 1)
            } else if (sum < target) {
                l += 1
            } else {
                r -= 1
            }
        }
        Array(-1, -1)
    }
}