class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        String s  = String.valueOf(x);
          for(int i = 0; i < words.length; i++){
            if(words[i].contains(s))
               list.add(i);
          }
          return list;
    }
}