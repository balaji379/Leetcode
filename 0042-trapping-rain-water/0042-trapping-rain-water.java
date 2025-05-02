class Solution {
    public int trap(int[] height) {
         int ans = 0;
         int left = 0, right = height.length - 1,leftmax = 0 , rightmax = 0;
         while (left <= right){
            if (height[left] <= height[right]){
                if (leftmax <= height[left])
                   leftmax = height[left];
                else ans += leftmax - height[left];
                left += 1;
            }
            else {
                if (rightmax <= height[right])
                   rightmax = height[right];
                else ans += rightmax - height[right];
                right -= 1;
            }
         }
         return ans;
    }
}