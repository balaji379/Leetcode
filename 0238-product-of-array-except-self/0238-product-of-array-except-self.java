class Solution {
    public int[] productElement(int[] nums){
        int length =nums.length,index=length-1,n=1,i=index,check=1;
        //condition 
        int[] ans=new int[length];
        while(i<length){
            if(i>0&&check==1){
               n*=nums[i--];
               ans[index--]=n;
            }
            else{
                check=0;
                if(i==0){
                    n=1;
                    ans[i]=ans[++index];
                    index++;
                   n*=nums[i++];
                   continue;
                }
                if(index<length){
                 ans[i]=n*ans[index++];
                 n*=nums[i++];
                 }
                 else
                 ans[i++]=n;
            }
        }
        return ans;
    }
    public int[] productExceptSelf(int[] nums) {
    return productElement(nums);
    }
}