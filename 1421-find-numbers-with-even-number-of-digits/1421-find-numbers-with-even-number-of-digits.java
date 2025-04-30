class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int val : nums){
            int sum = 0;
            while (val != 0){
                sum += 1;
                val /= 10;
            }
            if (sum % 2 == 0)
               count += 1;
        }
        return count;
        
    }
}