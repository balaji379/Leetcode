class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int v : candies) max = v>max? v:max;
        List<Boolean> ans= new ArrayList<>();
        for(int v : candies) ans.add((v+extraCandies)>=max);
        return ans;
    }
}