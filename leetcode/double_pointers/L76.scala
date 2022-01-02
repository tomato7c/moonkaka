object L76 {
    // 滑动窗口思想，难点是如何确定判断窗口边界，确保窗口内包含t中所有字符及数量
    // 借助map维护窗口内字符数量,>0表示多余，<0表示亏欠，初始化时t中所有字符处于亏欠状态
    // 窗口左边界右移时，只要保证要去掉的字符处于非亏欠的状态
    def minWindow(s: String, t: String): String = {
        var res = ""
        val map = new Array[Int](256)
        for (c <- t) map(c) -= 1

        var countWindowCharsInT = 0 // 窗口中包含t中字符数(去重)
        val tSize = t.distinct.length // t中去重后字符数量
        var left = 0
        for (right <- s.indices) {
            map(s(right)) += 1
            if (map(s(right)) == 0) countWindowCharsInT += 1
            if (countWindowCharsInT == tSize) { // 是合法的窗口
                while (map(s(left)) > 0) {
                    map(s(left)) -= 1
                    left += 1
                }
                if (res.isEmpty || res.length > right - left + 1) res = s.substring(left, right + 1)
            }
        }
        res
    } 
}