class Solution {
    public int scoreOfString(String s) {
        int left = 0 ,right = 1;
        int score = 0;
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        System.out.println((int)s.charAt(0));
        while (right < len){
           score += Math.abs(sb.charAt(left++) - sb.charAt(right++));
        }
        return score;
    }
}