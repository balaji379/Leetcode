class Solution {
    public int beautySum(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            HashMap<Character,Integer> map = new HashMap<>();
            for(int j = i; j < s.length(); j++){
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0) + 1);
                int min = Collections.min(map.values());
                int max = Collections.max(map.values());
                if(max - min > 0) ans+=max-min;
            }
        }
        return ans;
    }
}