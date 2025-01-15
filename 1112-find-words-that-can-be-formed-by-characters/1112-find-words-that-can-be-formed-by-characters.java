class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c : chars.toCharArray())
             map.put(c,map.getOrDefault(c,0) + 1);
        int sumlen = 0;
        boolean flag = true;
        for (String word : words){
            int len = word.length();
            flag = true;
            Map<Character,Integer> compare = new HashMap<>();
             for (int i = 0; i < len; i++){
                if (map.containsKey(word.charAt(i))){
                       if (compare.containsKey(word.charAt(i))) {
                            if (map.get(word.charAt(i)) > compare.get(word.charAt(i)))
                                    compare.put(word.charAt(i),compare.getOrDefault(word.charAt(i),0) + 1);
                            else{
                                flag = false;
                                break;
                            }            
                       }
                       else
                           compare.put(word.charAt(i),1);
                }
                else{
                    flag = false;
                    break;
                }
             }
             if (flag)
                sumlen += word.length();
        }
        return sumlen;
    }
}