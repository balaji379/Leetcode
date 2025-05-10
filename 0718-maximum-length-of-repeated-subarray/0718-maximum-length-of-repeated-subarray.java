class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int max = 0;
      for (int i = 0; i < nums1.length; i++){
        for (int j = 0; j < nums2.length; j++){
            if (nums1[i] == nums2[j]){
                int start = i, t = j;
                for (int k = j; k < nums2.length && start < nums1.length && nums1[start] == nums2[k]; ++k,++start,++t){
                    max = Math.max(max ,(start - i) + 1);
                }
            }
        }
      }
      return max;
    }
}