object L165 {
    def compareVersion(version1: String, version2: String): Int = {
        val arr1 = version1.split("\\.")
        val arr2 = version2.split("\\.")
        val n = Math.max(arr1.length, arr2.length)
        for (i <- 0 until n) {
            val a = safeIndex(arr1, i).toInt
            val b = safeIndex(arr2, i).toInt
            if (a > b) return 1
            if (a < b) return -1
        }
        0
    }

    private def safeIndex(arr: Array[String], i: Int): String = if (i < arr.length) arr(i) else "0"
}