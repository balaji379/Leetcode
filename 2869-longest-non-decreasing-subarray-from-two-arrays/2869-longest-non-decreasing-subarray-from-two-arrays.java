class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
         return solve(nums1,nums2);
    }
    public  int solve(int[] a, int[] b) {
        int[] dpa = new int[a.length];
        int[] dpb = new int[a.length];
        dpa[0] = 1;
        dpb[0] = 1;
        int max = 0;
        for (int i = 1; i < a.length; i++) {
            int maxf = 0, maxs = 0;
            if (a[i - 1] <= a[i]) {
                maxf = dpa[i - 1];
            }
            if (b[i - 1] <= a[i])
                maxs = dpb[i - 1];
            dpa[i] = Math.max(maxf, maxs) + 1;
            maxs = 0;
            maxf = 0;
            if (a[i - 1] <= b[i]) {
                maxf = dpa[i - 1];
            }
            if (b[i - 1] <= b[i])
                maxs = dpb[i - 1];
            dpb[i] = Math.max(maxf, maxs) + 1;
                        max = Math.max(Math.max(dpa[i], dpb[i]),max);

        }

        return max == 0 ? 1 : max;
    }
}