object Solution {
    def addDigits_v1(num: Int): Int = {
        var n = num
        while (n >= 10) {
            var temp = 0
            while (n > 0) {
                temp += n % 10
                n /= 10
            }
            n = temp
        }
        n
    }

    // Digital root的概念，可以找出规律
    def addDigits_v2(num: Int): Int = {
        if (num == 0) return 0
        if ((num % 9) == 0) return 9
        num % 9
    }
}