class Solution {
    public int longestSubstring(String s, int k) {
        int maxLength = 0;

        
        for (int uniqueChars = 1; uniqueChars <= 26; uniqueChars++) {
            int[] count = new int[26];
            int start = 0, end = 0, uniqueCount = 0, countAtLeastK = 0;

            while (end < s.length()) {
                
                if (uniqueCount <= uniqueChars) {
                    int index = s.charAt(end) - 'a';
                    if (count[index] == 0) uniqueCount++;
                    count[index]++;
                    if (count[index] == k) countAtLeastK++;
                    end++;
                } else {
                    
                    int index = s.charAt(start) - 'a';
                    if (count[index] == k) countAtLeastK--;
                    count[index]--;
                    if (count[index] == 0) uniqueCount--;
                    start++;
                }

                if (uniqueCount == uniqueChars && uniqueCount == countAtLeastK) {
                    maxLength = Math.max(maxLength, end - start);
                }
            }
        }

        return maxLength;
    }
}