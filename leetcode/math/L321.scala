object Solution {
    // 分治，num1求最长长度a的数，num2求最大长度b的数，a + b = k, 此时对a,b merge
    def maxNumber(nums1: Array[Int], nums2: Array[Int], k: Int): Array[Int] = {
        var res = new Array[Int](k)

        for (leftSize <- 0 to k) {
            val rightSize = k - leftSize
            if (leftSize <= nums1.length && rightSize <= nums2.length) {
                val candidate = merge(maxNumber(nums1, leftSize), maxNumber(nums2, k - leftSize))
                res = max(res, candidate)
            }
        }
        res
    }

    private def maxNumber(arr: Array[Int], k: Int): Array[Int] = {
        if (k == 0) return Array()
        var delete = arr.length - k
        if (delete == 0) return arr
        val stack = collection.mutable.Stack[Int]()
        for (v <- arr) {
            while (stack.nonEmpty && stack.top < v && delete > 0) {
                stack.pop
                delete -= 1
            }
            stack.push(v)
        }
        while (delete > 0) {
            stack.pop
            delete -= 1
        }
        stack.reverse.toArray
    }

    private def merge(arr1: Array[Int], arr2: Array[Int]): Array[Int] = {
        var a = 0; var b = 0
        var index = 0
        val res = new Array[Int](arr1.length + arr2.length)
        while (a < arr1.length || b < arr2.length) {
            if (compare(arr1, arr2, a, b)) {
                res(index) = arr1(a)
                a += 1
            } else {
                res(index) = arr2(b)
                b += 1
            }
            index += 1
        }
        res.toArray
    }

    // arr1 > arr2 with a and b index
    private def compare(arr1: Array[Int], arr2: Array[Int], a: Int, b: Int): Boolean = {
        var i = a; var j = b
        while (true) {
            if (i >= arr1.length) return false
            if (j >= arr2.length) return true
            if (arr1(i) == arr2(j)) {
                i += 1
                j += 1
            } else {
                return arr1(i) > arr2(j)
            }
        }
        false
    }

    private def max(arr1: Array[Int], arr2: Array[Int]): Array[Int] = {
        if (compare(arr1, arr2, 0, 0)) arr1 else arr2
    }
}