class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        return maxFreqs(s, maxLetters,  minSize,  maxSize);
    }
     public int maxFreqs(String s, int maxLetters, int minSize, int maxSize) {
         Map<String,Integer> count = new HashMap<>();
         int len = s.length() - minSize;
         int end = minSize;
         int max = 0;
         for(int i = 0; i < len + 1 ; i++,end++){
             String sub = s.substring(i,end);
             if (isValid(sub,maxLetters)){
                 count.put(sub,count.getOrDefault(sub,0) + 1);
                 max = Math.max(max,count.get(sub));
             }
         }
         return max;
    }
    public boolean isValid(String s,int maxLetterrs){
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray())
              set.add(c);
        if (set.size() <= maxLetterrs)
             return true;
        return false;
    }
}