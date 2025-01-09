class Solution {
    public boolean isNumber(String s) {
        int len = s.length() - 1;
        if (s.charAt(len) == 'e' || s.charAt(len) == 'E')
             return false;
        return isValidNum(s);
    }
     public  boolean isValidNum(String str) {
        boolean num = false, sign = false, e = false, dot = false;
        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9')
                num = true;
            else if (c == 'e' || c == 'E') {
                if (e == true || num == false) {
                    return false;
                } else {
                     e = true;
                     num = false;
                     sign = false;
                     dot = false;
                }
            } else if (c == '.') {
                if ( e == true || dot == true)
                     return false;
                else{
                    dot = true;
                }
            } else if (c == '+' || c == '-') {
                if (dot == true || sign == true || num == true)
                     return false;
                else {
                    sign = true;
                }
            }
            else
                return false;
        }

   if (sign == true && num == false || dot == true && num == false)
            return false;
        else
         return true;
    }

}