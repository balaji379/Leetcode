class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> ans = new HashSet<>();
         for (int i = 0; i < digits.length; i++){
            if (digits[i] == 0)
              continue;
            int a = digits[i] * 100;
            for (int j = 0; j < digits.length; ++j){
                int b = 0;
                if (j != i)
                     b = digits[j] * 10;
                else continue;
                for (int k = 0; k < digits.length; ++k){
                    int c = 0;
                  if (k != i && k != j)
                       c = digits[k];
                  else continue;
                  int num = a + b + c;
                  if (num % 2 == 0)
                     ans.add(num);
                }
            }
         }
         int[] nums = new int[ans.size()];
         int i = 0;
         for (int val : ans)
            nums[i++] = val;
         Arrays.sort(nums);
         return nums;
    }
}