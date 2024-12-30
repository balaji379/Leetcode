class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String temp = s.replaceAll("-","").toUpperCase();
        int len = temp.length();
        if (len == 0)
           return temp;
        int maxDash = s.length() - temp.length(),
            lenFirstG = temp.length() % k,
            count = 0;
        if (lenFirstG == 0)
            lenFirstG = k;
        StringBuilder sb = new StringBuilder("");
        for (int i = 0;lenFirstG > i; i++) 
             sb.append(temp.charAt(i));
        if (lenFirstG == len)
            return sb.toString();
        else {
            sb.append('-');
            for (int i = lenFirstG; i < len; i++,count++ ){
                if (count == k){
                    count = 0;
                    sb.append('-');
                }
                sb.append(temp.charAt(i));   
            }
        }
return sb.toString();
        
    }
}