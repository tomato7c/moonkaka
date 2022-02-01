object Solution {

    private val aeiou = Array('a','e','i','o','u','A','E','I','O','U')

    def reverseVowels(s: String): String = {
        var i = 0; var j = s.length - 1
        val arr = s.toArray

        while (i < j) {
            while (i < arr.length && !aeiou.contains(arr(i))) i += 1
            while (j >= 0 && !aeiou.contains(arr(j))) j -= 1
            if (i < j) swap(arr, i, j)
            i += 1; j -= 1
        }
        new String(arr)
    }

    private def swap(arr: Array[Char], a: Int, b: Int) {
        val temp = arr(a)
        arr(a) = arr(b)
        arr(b) = temp
    }
}