class Solution {
    public int search(int[] nums, int target) {
      
 int left=0,right=nums.length-1,mid=0;
 
      if(nums.length==1){
      if(nums[0]==target ) 
      return 0;
      return -1;
      }
    
  while(left<right){
      mid=(right+left)/2;
      if(nums[mid]==target)
      return mid;
      else if(nums[left]==target)
      return left;
      else if(nums[right]==target)
        return right;
      if(nums[mid]<nums[right])right=mid;
      else
      left=mid+1;
  }
  if(left==0)
  right=nums.length-1;
  else if(nums[0]<=target&&target<=nums[left-1]){
      right=left-1;
      left=0; 
  }
  else
      right=nums.length-1;

       while(left<=right){
      mid=(right+left)/2;
      if(nums[mid]==target){
      return mid;
       }
       else if(nums[mid]>target){
         right=mid-1;
       }
       else if(nums[mid]<target){
           left=mid+1;
       }
    }
return -1;    
}

    }