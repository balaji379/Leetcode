class Solution {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        Arrays.sort(words);
        // System.out.println(Arrays.toString(words));
        String res = "";
        for (int i = 0; i < words.length; i++){
               String s = words[i];
               if (s.length() == 1 || set.contains(s.substring(0,s.length() - 1))){
                    if (res.length() < s.length())
                         res = s;
                    set.add(s);
               }
            }
        return res;
    }
}