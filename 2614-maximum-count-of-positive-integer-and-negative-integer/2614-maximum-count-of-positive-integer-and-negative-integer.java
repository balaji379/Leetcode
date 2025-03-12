class Solution {
    public int maximumCount(int[] nums) {
        int neg = 0, p = 0;
        for (int val : nums){
            if (val < 0)
                  neg += 1;
            else if (val > 0)                
               p += 1;
        }
        if (neg > p)
          return neg;
          return p;
          
    }
}