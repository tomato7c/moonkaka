class L220 {
    // 问题可以简化为，在[i,j]窗口内，寻找与arr(i)值最接近的数, 是否在[v-t,v+t]范围内, 
    public boolean containsNearbyAlmostDuplicate(int[] arr, int k, int t) {
        if (arr.length < 1 || k == 0) return false;

        TreeSet<Integer> tree =  new TreeSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            Integer floor = tree.floor(v);
            Integer ceil = tree.ceiling(v);
            if (floor != null && floor >= (long)v - t) return true;
            if (ceil != null && ceil <= (long)v + t) return true;
            tree.add(v);
            if (i >= k) tree.remove(arr[i - k]);
        }

        return false;
    }
}