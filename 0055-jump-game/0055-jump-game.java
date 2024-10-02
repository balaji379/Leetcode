class Solution {
    public boolean canJump(int[] nums) {
        int i=0,step=nums[0],size=nums.length,length=size-1;
        if(length==step||length==0)
        return true;
        if(step==0)
        return false;
        while(i<size){
            step--;
            i++;
            if(i==length)
            return true;
            else if(nums[i]>=step){
            step=nums[i];
            if(step==0)
            return false;
            }
        }
        return false;
    }
}