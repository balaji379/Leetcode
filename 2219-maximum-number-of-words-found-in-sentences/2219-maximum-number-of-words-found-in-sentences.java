class Solution {
    public int mostWordsFound(String[] sentences) {
         int max = 0;
         for (String temp : sentences){
            String[] words = temp.split(" ");
            max = max < words.length ? words.length : max;
         }
         return max;
    }
}