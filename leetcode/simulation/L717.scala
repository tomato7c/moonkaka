object Solution {
    def isOneBitCharacter(bits: Array[Int]): Boolean = {
        var i = 0
        while (i < bits.length - 1) {
            if (bits(i) == 0) i += 1
            else i += 2
        }
        i == bits.length - 1
    }
}