class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer>list=new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            while(nums[i]>0){
                list.add(nums[i]%10);
                nums[i]/=10;
            }
        }
        int[] ans=new int[list.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=list.get(ans.length-i-1);
        }
        return ans;
    }
}