class Solution {
    public boolean divideArray(int[] nums) {
         int[] count = new int[501];
         for (int val : nums){
            count[val] += 1;
         }
         int pairs = nums.length / 2;
         int sum_of_pairs = 0;
         for (int val : nums){
            if (count[val] % 2 == 0){
                 sum_of_pairs += (count[val] / 2);
                 count[val] = 0;
            }
            else return false;
         }
         if (sum_of_pairs == pairs)
             return true;
        else return false;
    }
}