/* The isBadVersion API is defined in the parent class VersionControl.
      def isBadVersion(version: Int): Boolean = {} */

class Solution extends VersionControl {
    // isBadVersion 最左端
    def firstBadVersion(n: Int): Int = {
        var l = 1; var r = n
        while (l < r) {
            val mid = (l + r) >>> 1
            if (isBadVersion(mid)) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        l
    }
}
