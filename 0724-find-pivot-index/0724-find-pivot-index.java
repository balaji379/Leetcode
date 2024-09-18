class Solution {
    public int pivotIndex(int[] nums) {
      int[] left = new int[nums.length];
      int[] right = new int[nums.length];
      int first = 0, last = 0;
      for(int i = 0,j = nums.length-1; i<nums.length && j>=0 ; i++,j--){
        if(i==0 || j==nums.length-1){
            left[i] = 0;
            right[j] = 0;
        }  else {
              left[i] = first ;
              right[j] = last;

        }
     first += nums[i];
     last += nums[j];
      }
    //   System.out.println("the left array is :"+Arrays.toString(left));
    //   System.out.println("the right array is :"+Arrays.toString(right));
      for(int i = 0; i <nums.length ; i++){
        if(left[i] == right[i]) 
            return i;
      }
      return -1 ;
      }
}
