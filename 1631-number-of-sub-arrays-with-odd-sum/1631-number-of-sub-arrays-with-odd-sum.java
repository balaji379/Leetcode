class Solution {
    public int numOfSubarrays(int[] arr) {
        long ans =  countNoOfSubArrayWithSumEqualToOdd(arr);
        if (ans > Integer.MAX_VALUE){
            long d = (long)(Math.pow(10,9) + 7);
            return (int)(ans % d);
        }
        else return (int)ans;
    }
      public  long countNoOfSubArrayWithSumEqualToOdd(int... nums) {
        int[] prefix = new int[nums.length + 1];
        int[] even = new int[nums.length + 1];
        int[] odd = new int[nums.length + 1];
        prefix[0] = 0;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
            if (prefix[i] % 2 == 0) {
                even[i] = even[i - 1] + 1;
                odd[i] = odd[i - 1];
            } else {
                odd[i] = odd[i - 1] + 1;
                even[i] = even[i - 1];
            }
        }
        long count = 0;
        for (int i = 0; i < prefix.length; i++) {
            if (prefix[i] != 0 && prefix[i] % 2 == 0){
                count += odd[i];
            }
            else if (prefix[i] != 0 && prefix[i] % 2 != 0){
                count += even[i];
                count += 1;
            }
        }
        return count;

    }
}