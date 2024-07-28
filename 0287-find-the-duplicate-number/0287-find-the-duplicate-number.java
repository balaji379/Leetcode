class Solution {
    public int findDuplicate(int[] nums) {
        
        int[] count = new int[nums.length];
        for(int i=0 ;i<nums.length;i++){
            count[nums[i]-1]+=1;
            if( count[nums[i]-1]==2) 
                    return nums[i];
        }
        // System.out.println("the array value is :"+Arrays.toString(count));
       return -1;
    }
}