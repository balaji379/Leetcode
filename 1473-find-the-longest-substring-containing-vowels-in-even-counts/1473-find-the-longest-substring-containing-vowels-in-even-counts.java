class Solution {
    public int findTheLongestSubstring(String s) {
        return findLosgestSub(s);
    }
       public static int findLosgestSub(String s){
        int bitmash = 0,max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int len = s.length();
        for (int i = 0; i < len; i++){
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'u' || c == 'o'){
                bitmash = bitmash ^ (1 << (int)(c-'a'));
            }
            if (map.containsKey(bitmash)){
                int ans = i - map.get(bitmash);
                max = Math.max(max,ans);
            }
            else map.put(bitmash,i);
        }
        return max;
    }
}