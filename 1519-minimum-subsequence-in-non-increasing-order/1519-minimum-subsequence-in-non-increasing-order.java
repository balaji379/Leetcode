class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int s = 0;
        System.out.print(sum);
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--){
              s += nums[i];
              sum -= nums[i];
              list.add(nums[i]);
              if (s -sum > 0)
                  return list;  
        }
        return list;
    }
}