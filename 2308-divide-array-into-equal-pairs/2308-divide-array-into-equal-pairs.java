class Solution {
    public boolean divideArray(int[] nums) {
         Map<Integer,Integer> map = new HashMap<>();
         for (int val : nums){
            map.put(val,map.getOrDefault(val,0) + 1);
         }
         int pairs = nums.length / 2;
         int sum_of_pairs = 0;
         for (int val : map.values()){
            if (val % 2 == 0)
                sum_of_pairs += val / 2;
            else return false;
         }
         if (sum_of_pairs == pairs)
             return true;
        else return false;
    }
}