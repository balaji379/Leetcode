class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
       List<String> ans = null;
       int max = -1;
        for (int i = 0; i < words.length; i++) {
            List<Integer> index = new ArrayList<>();
            List<String> tempans = new ArrayList<>();
            for (int j = i; j < words.length; ++j) {
                  if (index.isEmpty()){
                      index.add(groups[j]);
                      tempans.add(words[j]);
                  }
                  else if (index.getLast() != groups[j]){
                    index.add(groups[j]);
                    tempans.add(words[j]);
                  }
            }
          if (max < index.size()){
            ans = tempans;
            max = index.size();
          }
        }
        return ans;
    }
}