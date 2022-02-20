class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]) {
                    return e1[0] - e2[0];
                } else {
                    return e2[1] - e1[1];
                }
            }});
            List<Integer> dp = new ArrayList<>();
            dp.add(envelopes[0][1]);
            for (int i = 1; i < envelopes.length; i++) {
                var newH = envelopes[i][1];
                if (newH > dp.get(dp.size() - 1)) {
                    dp.add(newH);
                } else {
                    // 找到第一个 >= newH的位置，替换
                    var l = 0; var r = dp.size() - 1;
                    while (l < r) {
                        final var mid = l + r >>> 1;
                        if (dp.get(mid) >= newH) {
                            r = mid;
                        } else {
                            l = mid + 1;
                        }
                    }
                    dp.set(l, newH);
                }
            }
            return dp.size();
    }
}