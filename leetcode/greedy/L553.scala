object Solution {
    // 贪心，让分母尽可能小
    def optimalDivision(nums: Array[Int]): String = {
        val sb = new StringBuilder(nums.mkString("/"))
        if (nums.length > 2) {
            sb.insert(sb.indexOf('/') + 1, '(')
            sb.append(')')
        }
        sb.toString
    }
}