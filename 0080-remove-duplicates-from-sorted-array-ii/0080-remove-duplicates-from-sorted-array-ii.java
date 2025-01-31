class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        int count = 0;
        int len = nums.length;
        while (j < len)   {
             if(nums[j] == nums[i]){
                count += 1;
             }
             else{
                if(count > 2){
                    int start = i + 2;
                    int end = j;
                    len -= (end - start);
                    while (end < nums.length){
                     nums[start++] = nums[end++];
                    }
                    j = i + 2;
                    count = 0;
                    continue;
                }
                else{
                    i = j;
                    count = 0;
                    continue;
                }
             }
             j += 1;
        }
// System.out.println(Arrays.toString(nums)+"count " + count + " i " + i + "len " + len);
    if (count > 2)
      return len - (count - 2);
    
    else 
       return len;
}
}