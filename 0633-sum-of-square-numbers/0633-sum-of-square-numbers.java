class Solution {
    public boolean judgeSquareSum(int c) {
        int end = (int)Math.sqrt(c),start = 0;
        if (c == 2 || c == 8 || c == 0 || c == 32)
           return true;
        while (start < end){
            int ans = (int)(Math.pow(start,2) + Math.pow(end,2));
            if (ans == c)
               return true;
            else if (ans < c)
               start += 1;
            else end -= 1;
        }
return false;
    }
}