class Solution {
    public int longestPalindrome(String s) {
         HashMap<Character,Integer> map = new HashMap<>();
         char[] letters = s.toCharArray();
         for(char letter : letters)
            map.put(letter,map.getOrDefault(letter,0)+1);
        int out = 0,odd = 0;
         for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue()%2==0)
                out += entry.getValue();
            else
               odd += 1;
         }
          return (letters.length - (odd==0?1:odd))+1;
    }
}