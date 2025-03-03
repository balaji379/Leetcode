class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
           int[] ans = new int[nums.length];
           int[] i = {0};
           Arrays.stream(nums).filter(e->e < pivot).forEach(e->ans[i[0]++] = e);
           Arrays.stream(nums).filter(e->e == pivot).forEach(e->ans[i[0]++] = e);
           Arrays.stream(nums).filter(e->e > pivot).forEach(e->ans[i[0]++] = e);
           return ans;
    }

}