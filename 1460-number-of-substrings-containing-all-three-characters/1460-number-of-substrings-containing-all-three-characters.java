class Solution {
    public int numberOfSubstrings(String s) {
        return solve(s);
    }
    public  int solve(String s){
        int[] letters = new int[26];
        StringBuilder sb = new StringBuilder();
        int i = 0,len = s.length(),letter = 0,sum = 0;
        while(i < len){
            char c = s.charAt(i);
            letters[c-'a'] += 1;
            sb.append(c);
            if (letters[c-'a'] == 1){
                letter += 1;
            }
            if (letter >= 3){
                int l = sb.length();
                while(letter >= 3){
                    int rest = (len - i);
                    sum += rest;
                    char cc = sb.charAt(0);
                    letters[cc-'a'] -= 1;
                    if (letters[cc-'a'] <= 0)
                         letter -= 1;
                    sb.deleteCharAt(0);
                }
            }
            i += 1;
        }
        // while(letter >= 3){
        //     sum += 1;
        //     char c = sb.charAt(0);
        //     letters[c-'a'] -= 1;
        //     if (letters[c-'a'] == 0)
        //          letter -= 1;
        // }
        return sum;
    }
}