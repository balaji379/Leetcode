class Solution {
    public int trap(int[] height) {
         int lhb = height[0] , rhb  = height[height.length - 1];
         int l = 0 , r = height.length - 1,res = 0;
         while (l <= r){
            if (lhb <= rhb){
               if (height[l] > lhb)
                   lhb = height[l];
               else
                   res += (lhb - height[l]);
               l += 1;
            }
            else {
                if (height[r] > rhb)
                   rhb = height[r];
                else
                  res += (rhb - height[r]);
                r --;
            }
         }
         return res;
    }
}