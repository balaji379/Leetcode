class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0,minlength=Integer.MAX_VALUE,sum=0;
        // Arrays.sort(nums);
       TreeSet <Integer> p=new TreeSet<>();
        while(j<nums.length){
            if(nums[j]==target)
            return 1;
            if(sum<target)
            sum+=nums[j];
             if(sum>=target){
                minlength=Math.min(minlength,(j-i)+1);
              sum=Math.abs(sum-nums[i++]);  
            }
            if(sum<target)
            j++;
        }
       if(minlength!=Integer.MAX_VALUE)
       return minlength;
       return 0;
    }
}