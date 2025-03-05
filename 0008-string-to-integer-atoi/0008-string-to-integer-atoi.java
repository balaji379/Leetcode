class Solution {
    public int myAtoi(String val) {
    val = val.trim();
        int len = val.length();
        int ans = 0;
        for (int i = 0; i < len; i++){
            char c = val.charAt(i);
           if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '.')
                 break;
            else if (c == '-' && i + 1 < len){
                char t = val.charAt(i + 1);
                if (t >= '0' && t <= '9'){
                     long d = getnum(i+1,val,true);
                     d *= -1;
                     if (d <= Math.abs(Integer.MIN_VALUE)) {
                         ans = Integer.MIN_VALUE;
                         break;
                     }else ans = (int)d;
                     break;
                }else break;
            }
            else if (c == '+' && i + 1 < len){
                char t = val.charAt(i + 1);
                if (t >= '0' && t <= '9'){
                    long d = getnum(i+1,val,false);
                    if (d >= Integer.MAX_VALUE) {
                        ans = Integer.MAX_VALUE;
                        break;
                    }else ans = (int)d;
                }else break;
            }
            else if(c >= '0' && c <= '9') {
                long  d = getnum(i,val,false);
                if (d > Integer.MAX_VALUE){
                    ans = Integer.MAX_VALUE;
                    break;
                }else ans = (int)d;
                break;
           }
        }
        return ans;
    }

    private static long getnum(int start, String s,boolean flag) {
        int temp = start,len = s.length();
        boolean z = false;
        int f = temp;
           while(start < len && s.charAt(start) >= '0' && s.charAt(start) <= '9'){
               if(s.charAt(start) == '0' && !z)
                     f += 1;
               else z = true;
               start += 1;
           }
//           if ()
           String d = s.substring(f,start);
           if (d.length() > 10){
               if (flag)
                    return -1 * Integer.MIN_VALUE;
               else return Integer.MAX_VALUE;
           }
           if (d.length() == 0)
                return 0;
            return Long.parseLong(d);
    }
}
