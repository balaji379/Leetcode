class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        long ans = Integer.MIN_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();
        long sum = 0;
        for(int i = 0;i < k; i++){
            map.put(nums.get(i),map.getOrDefault(nums.get(i),0) + 1);
            sum += nums.get(i);
        }

        if(map.keySet().size() >= m){
            ans = Math.max(ans,sum);
        }

        for(int i = k; i < nums.size(); i++){
            sum += nums.get(i);
            map.put(nums.get(i),map.getOrDefault(nums.get(i),0) + 1);
            sum -= nums.get(i-k);
            map.put(nums.get(i-k),map.get(nums.get(i-k)) - 1);
            if(map.get(nums.get(i-k)) == 0) map.remove(nums.get(i-k));
            if(map.keySet().size() >= m) ans = Math.max(ans,sum);
        }
        if(ans == Integer.MIN_VALUE) return 0;
        return ans;
    }
}