class Solution {
    public int index = 0;
    public String decodeString(String s) {
             return decode(1,s,s.length());
    }
    public  String decode(int val, String s, int len) {
        StringBuilder sb = new StringBuilder();
        while (index < len) {
            char c = s.charAt(index);
            if (c >= 'a' && c <= 'z')
                sb.append(c);
            else if (Character.isDigit(c)) {
                StringBuilder num = new StringBuilder();
                while (index < len && Character.isDigit(s.charAt(index))) {
                    num.append(s.charAt(index));
                    index += 1;
                }
                sb.append(decode(Integer.valueOf(num.toString()), s, len));
            }
            else if (c == ']'){
                 break;
            }
            index += 1;
        }

        return sb.toString().repeat(val);
    }
    
}