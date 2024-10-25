class Solution {
    static int sum(int k,int[] nums){
       int count = 0 , sum = 0;
       for(int i = 0; i < nums.length; i++){
              if( i < nums.length-1 && ( nums[i] < 0 && k > 0 ) ){
                    if(nums[i+1] < 0){
                         nums[i] *= -1;
                         k -=1;
                    }else{
                        if( nums[i] * -1 <= nums[i+1] ){
                            if(k % 2 != 0)
                               nums[i] *= -1;
                        }else{
                           nums[i] *= -1;
                           k -= 1;
                           if( k % 2 != 0 )
                               nums[i + 1]  *= -1;
                        }
                        k = 0;
                    }
              }else{
                if( k % 2 != 0 && k > 0 || k == 1){
                    nums[i] *= -1;
                    k = 0;
                }
              }
               sum += nums[i];
       }
     return sum;
    }
    public int largestSumAfterKNegations(int[] nums, int k) {
         Arrays.sort(nums);
        return sum(k,nums);
          
    }
}