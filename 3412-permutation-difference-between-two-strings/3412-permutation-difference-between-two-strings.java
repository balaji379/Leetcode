class Solution {
    public int findPermutationDifference(String s, String t) {
        Map<Character,Integer> smap = new HashMap<>();
        Map<Character,Integer> tmap = new HashMap<>();
        int[] ans = {0};
        IntStream.range(0,s.length()).forEach(i->smap.put(s.charAt(i),i));
        IntStream.range(0,t.length()).forEach(i->tmap.put(t.charAt(i),i));
        IntStream.range(0,s.length())
            .forEach(i->{
                char c = s.charAt(i);
              ans[0] += (Math.abs(smap.get(c)-tmap.get(c)));
            });
        return ans[0];
    }
}