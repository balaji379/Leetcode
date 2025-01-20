class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] concatarr = new int[nums.length + nums.length];
        int firstStart = 0 ,secondStart = nums.length;
        int index = 0;
        while (firstStart < nums.length && secondStart < concatarr.length){
            concatarr[firstStart++] = nums[index];
            concatarr[secondStart++] = nums[index++];
        }
        return concatarr;
    }
}