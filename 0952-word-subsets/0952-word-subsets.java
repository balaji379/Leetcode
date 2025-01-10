class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        return getWordSubset(words1,words2);
    }
     public static List<String> getWordSubset(String[] word1,String[] word2){
        List<String> answer = new LinkedList<>();
        int[] lettercount = new int[26];
        for (String val:word2){
            char[] letter = val.toCharArray();
            int[] templettercount = new int[26];
            for (int i = 0; i < letter.length; i++){
                if (lettercount[letter[i] - 97] == 0  ){
                    lettercount[letter[i] - 97] = 1;
                    templettercount[letter[i] - 97] = 1;
                }else {
                    templettercount[letter[i] - 97] += 1;
                    if (templettercount[letter[i] - 97] > lettercount[letter[i] - 97])
                         lettercount[letter[i] - 97] = templettercount[letter[i] - 97];
                }
            }

        }
        for (String val : word1){
            int[] world1Count = new int[26];
            boolean flag = true;
            for (char c : val.toCharArray())
                 world1Count[c - 97] += 1;
            for (int i = 0; i < lettercount.length;i++){
                if (lettercount[i] != 0 && (world1Count[i] < lettercount[i])) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                 answer.add(val);
        }
        return answer;
    }
}