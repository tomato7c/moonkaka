object Solution {
    // [1,5] [4,3] [10,4]
    // attack从大到小，def从小到大；最主要是规避maxDef小于cur的情况下，cur.attack大于等于前面的，但排序后cur.attack只可能小于等于前面，且def从小到大排序,maxDef大于cur时，cur.attach只会是小值
    def numberOfWeakCharacters(properties: Array[Array[Int]]): Int = {
        val arr = properties.sortWith((a, b) => {
            if (a(0) == b(0)) a(1) < b(1) else a(0) > b(0)
        })
        var res = 0
        var maxDef = 0
        for (c <- arr) {
            if (maxDef > c(1)) res += 1
            else maxDef = maxDef.max(c(1)) 
        }
        res
    }
}