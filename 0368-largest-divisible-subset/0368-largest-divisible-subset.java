class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length == 1)
            return List.of(nums[0]);
         return solve(nums);
    }

    public  List<Integer> solve(int... nums) {
        Arrays.sort(nums);
        int[] dp= new int[nums.length];
        Arrays.fill(dp,1);;
        int max = 1;
        for (int i = 0; i < nums.length; i++){
             int pre = nums[i];
            for (int  j = i + 1; j < nums.length; j++){
                      if (nums[j] % pre == 0){
                           int count = dp[i] + 1;
                           if (dp[j] < count) {
                               dp[j] = count;
                               if (max < count)
                                    max = count;
                           }
                      }
            }
        }

        int pre = -1;
        // System.out.println("the max value is : " + max);
        List<Integer> ans = new ArrayList<>();
        
        for (int i = dp.length - 1; i >= 0; i--){
            if (dp[i] == max && ( pre % nums[i] == 0 || pre == -1 )){
                max -= 1;
                pre = nums[i];
                ans.add(nums[i]);
            }
        }
   
        // System.out.println(Arrays.toString(dp));
        // System.out.println(ans);
        return ans;
    }
}
