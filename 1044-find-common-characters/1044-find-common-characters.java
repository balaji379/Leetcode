class Solution {
    public List<String> commonChars(String[] words) {
          
        int[] charCount = new int[26];
        
        
        for (char c : words[0].toCharArray()) {
            charCount[c - 'a']++;
        }

       
        for (int i = 1; i < words.length; i++) {
            int[] currentCount = new int[26];
            for (char c : words[i].toCharArray()) {
                currentCount[c - 'a']++;
            }
           
            for (int j = 0; j < 26; j++) {
                charCount[j] = Math.min(charCount[j], currentCount[j]);
            }
        }

       
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < charCount[i]; j++) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }

        return result;
    }
    
}