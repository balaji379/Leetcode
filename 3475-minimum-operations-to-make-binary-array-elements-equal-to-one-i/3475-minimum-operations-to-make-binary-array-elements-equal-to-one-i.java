class Solution {
    public int minOperations(int[] nums) {
           int start = 0,len = nums.length,min = 0;
           while (start < len - 2){
               if (nums[start] == 0){
                int end = start;
                   while ((end - start) + 1 <= 3 && end < len){
                      if (nums[end] == 0)
                          nums[end] = 1;
                      else nums[end] = 0;
                      end += 1;
                   }
                   min += 1;
               }
               start +=1;
           }
           for (int v : nums){
            if (v == 0)
               return -1;
           }
           return min;
    }
}