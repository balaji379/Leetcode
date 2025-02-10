class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++){
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9' ){
                if (sb.length() >= 1)
                    sb.deleteCharAt(sb.length() - 1);
            }
            else
               sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}