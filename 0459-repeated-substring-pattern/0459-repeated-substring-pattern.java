class Solution {
     static boolean pattern(String str) {
       

        int len = str.length();
        for (int i = 0; i < len; i++) {
            String s = str.substring(0, i + 1);
            if (s.length() <= (len - s.length())) {
                int first = 0, second = s.length();
                boolean flag = true;
                while (flag && second < len) {
                    if (s.charAt(first) != str.charAt(second))
                        flag = false;
                    else {
                        first += 1;
                        second += 1;
                    }
                    if (first == s.length())
                        first = 0;
                }
                if (flag && first==0)
                    return true;
            } else
                return false;
        }
        return true;
    }
    public boolean repeatedSubstringPattern(String s) {
        return Solution.pattern(s);
    }
}