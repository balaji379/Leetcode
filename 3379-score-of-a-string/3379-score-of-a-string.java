class Solution {
    public int scoreOfString(String s) {
        int left = 0 ,right = 1;
        int score = 0;
        System.out.println((int)s.charAt(0));
        while (right < s.length()){
           score += Math.abs(s.charAt(left++) - s.charAt(right++));
        }
        return score;
    }
}