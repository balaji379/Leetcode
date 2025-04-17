class Solution {
    public int numSub(String s) {
          long count = 0;
         long w = 0;
         int start = 0 ,end = 0,len = s.length();
         while (end < len){
            w = 0;
            if (s.charAt(end) == '1'){
            while (end < len && s.charAt(end) == '1'){
                  w += 1;
                  end += 1;
            }
            count += ((w * (w+1)) / 2);
            continue;
            }
            end += 1;
         }
        if (count > Integer.MAX_VALUE){
            return (int)(count % (Math.pow(10,9) + 7));
        }else return (int)count;
    }
}