class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int len = chars.length;
        for (int i = 0; i < len; i++){
            int start = i;
            int size = 0;
            sb.append(chars[i]);
            while (start < chars.length){
                 if (chars[i] == chars[start])
                     size += 1;
                 else {
                    break;
                 }
                 start += 1;
            }
            if (size > 1)
              sb.append(size);
            i = start - 1;
        }
        len = sb.length();
        String s = sb.toString();
        for (int i = 0; i < len; i++){
            chars[i] = s.charAt(i);
        }
        return sb.length();
    }
}