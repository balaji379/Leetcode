class Solution {
    public int countHomogenous(String s) {
         long count = 0;
         long w = 0;
         int start = 0 ,end = 0,len = s.length();
         while (end < len){
            char pre = s.charAt(end);
            w = 0;
            while (end < len && pre == s.charAt(end)){
                  w += 1;
                  end += 1;
            }
            count += ((w * (w+1)) / 2);
         }
        if (count > Integer.MAX_VALUE){
            return (int)(count % (int)(Math.pow(10,9) + 7));
        }else return (int)count;
    }
}