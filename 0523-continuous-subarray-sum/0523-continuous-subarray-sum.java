class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
         int[] presum = new int[nums.length + 1];
         HashMap<Integer,Integer> map = new HashMap<>();
         presum[0] = 0;
         for(int i = 1; i < presum.length; i++){
            presum[i] = presum[i-1] + nums[i-1];
         }
         for( int i = 0; i < presum.length ;i++){
            presum[i] %= k;
            if (!map.containsKey(presum[i]))
               map.put(presum[i] , i);

         }
         for (int i = 0; i < presum.length; i++){
             if (map.containsKey(presum[i])){
                if( Math.abs(map.get(presum[i]) - i) >= 2) 
                  return true;
             }
         }
         return false;
    }
}