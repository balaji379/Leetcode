class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int end = 0,start = 0,max = 0;
        for (int i = 1; i < len; i++) {
            int l = i-1;
            int r = i;
            while(l >= 0 && r < len &&  s.charAt(l) == s.charAt(r)){
                int m =  r - l + 1;
                if (max <= m){
                    start = l;
                    max = m;
                    end = r - l + 1;
                }
                l -= 1;
                r += 1;
            }
            l = i - 1;
            r = i + 1;
            while(l >= 0 && r < len && s.charAt(l) == s.charAt(r)){
                int m = r - l +1;
                if (m >= max){
                    start = l;
                    end = r - l + 1 ;
                    max = m;
                }
                l -= 1;
                r += 1;
            }
        }
        System.out.println("the longest substring is : " + start + " " + (max + start));
        if (start == 0 && max == 0)
             return String.valueOf(s.charAt(0));
        return s.substring(start,max + start);
    }
}
