/** 
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * def guess(num: Int): Int = {}
 */

class Solution extends GuessGame {
    // 二分guess <= 0的最左端
    def guessNumber(n: Int): Int = {
        var l = 1; var r = n
        while (l < r) {
            val mid = l + r >>> 1
            if (guess(mid) <= 0) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        l
    }
}