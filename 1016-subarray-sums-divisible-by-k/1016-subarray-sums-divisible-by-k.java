class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] prefixsum = new int[nums.length + 1];
        int totalcount = 0;
        for (int i = 0; i < nums.length; i++){
             prefixsum[i + 1] = prefixsum[i] + nums[i];
        }
        for (int i = 0; i < prefixsum.length; i++)
          prefixsum[i] = ((prefixsum[i] % k) +k) % k;
        for (int remainder : prefixsum) {
            if (map.containsKey(remainder)){
                 totalcount += map.get(remainder);
            }
            map.put(remainder,map.getOrDefault(remainder,0) + 1);
        }
    
        return totalcount;
    }
}