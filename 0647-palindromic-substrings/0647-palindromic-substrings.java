class Solution {
    public int countSubstrings(String s) {
        int start = 0,len = s.length();
        int count = 0;
        for(int i = 1; i < len; i++){
            int l = i - 1;
            int r = i;
            while (l >=0 && r < len && s.charAt(l) == s.charAt(r)){
                  count += 1;
                  l -= 1;
                  r += 1;
            }
            l = i - 1;
            r = i + 1;
            while(l >= 0 && r < len && s.charAt(l) == s.charAt(r)){
                count += 1;
                l -= 1;
                r += 1;
            }
        }
        return count + len;
    }
}