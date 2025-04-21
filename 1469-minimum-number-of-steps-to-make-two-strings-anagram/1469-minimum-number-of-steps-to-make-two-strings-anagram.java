class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> first = new HashMap<>();
        Map<Character, Integer> second = new HashMap<>();
        for (char c : t.toCharArray()){
            second.put(c,second.getOrDefault(c,0) + 1);
        }
        for (char c : s.toCharArray()){
            if (second.containsKey(c)){
                if (second.get(c) > 0)
                    second.put(c,second.get(c) - 1);
            }
        }
        int count  =  0;
        for (int val : second.values())
           count += val;
        
       return count;   
    }
}
