class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
         Map<String,Integer> map = new HashMap<>();
         for(int[] dominoe : dominoes){
            Arrays.sort(dominoe);
            String s = Arrays.toString(dominoe);
            map.put(s,map.getOrDefault(s,0) + 1);
         }
         int ans = 0;
         for (int n : map.values()){
            ans += ((n * (n - 1))/2);
         }
         return ans;
    }
}