## 排序
#### 快排
1. 确定分界点pivot (可以直接选择最左端
2. 调整区间，使<=pivot的在左边，>=pivot的在右边
3. 针对每个区间递归
```
  private def quickSort(arr: Array[Int]): Unit = quickSort(arr, 0, arr.length - 1)

  private def quickSort(arr: Array[Int], l: Int, r: Int): Unit = {
    if (l >= r) return

    val pivot = arr(l); var i = l - 1; var j = r + 1
    while (i < j) {
      do i +=1 while(arr(i) < pivot) // 使i位于>=pivot位置
      do j -= 1 while (arr(j) > pivot) // 使j位于<=pivot位置
      if (i < j) swap(arr, i, j)
    }
    quickSort(arr, l, j)
    quickSort(arr, j + 1, r)
  }
```

#### 归并
1. 确定中点
2. 中点前mergeSort, 中点后mergeSort
3. 针对中点前后的两个

```
  private def mergeSort(arr: Array[Int]): Unit = mergeSort(arr, 0, arr.length - 1)

  private def mergeSort(arr: Array[Int], l: Int, r: Int): Unit = {
    if (l >= r) return;

    val mid = (l + r) / 2
    mergeSort(arr, l, mid)
    mergeSort(arr, mid + 1, r)
    merge(arr, l, mid, r)
  }

  // merge [l, mid], [mid + 1, r] in-place
  private def merge(arr: Array[Int], l: Int, mid: Int, r: Int): Unit = {
    var p = l; var q = mid + 1
    val temp = new Array[Int](r - l + 1)
    var index = 0
    while (p <= mid && q <= r) {
      if (arr(p) <= arr(q)) {
        temp(index) = arr(p)
        index += 1; p += 1
      } else {
        temp(index) = arr(q)
        index += 1; q += 1
      }
    }
    while (p <= mid) {
      temp(index) = arr(p)
      index += 1
      p += 1
    }
    while (q <= r) {
      temp(index) = arr(q)
      index += 1
      q += 1
    }
    for (i <- temp.indices) arr(l + i) = temp(i)
  }
```

#### 堆排 TODO



## 二分
#### 整数二分
#### 浮点数二分