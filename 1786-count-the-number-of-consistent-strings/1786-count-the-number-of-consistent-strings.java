class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int matchCount = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (char letter : allowed.toCharArray()){
            map.put(letter,map.getOrDefault(letter,0));
        }
        for (String s : words){
            boolean flag = true;
            for (char c : s.toCharArray()){
                     if (!map.containsKey(c))
                        flag = false;
                     if (!flag)
                        break;
            }
            if (flag)
               matchCount += 1;
        }
        return matchCount;
    }
}