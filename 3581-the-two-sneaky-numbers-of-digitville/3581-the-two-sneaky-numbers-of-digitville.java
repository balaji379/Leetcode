class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[]a=new int[2];
        int b=0;
        HashSet<Integer>set=new HashSet<>();
        for(int ans : nums){
            if(set.contains(ans)){
                a[b]=ans;
                b++;
            }
            else{
                set.add(ans);
            }
        }
        return a;
    }
}