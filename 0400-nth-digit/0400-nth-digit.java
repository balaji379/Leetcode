class Solution {
    public int findNthDigit(int n) {
         int digit = 1,digitinterval = 9;
         while (n - digitinterval > 0){
            n -= digitinterval;
            digit += 1;
            digitinterval = 9 * (int)Math.pow(10,digit - 1) * digit;
            if (digitinterval < 0)
               break;
         }
         int base = (int)Math.pow(10,digit - 1);
         int num = base + (n-1) / digit;
         return (String.valueOf(num).charAt((n-1) % digit) ) - '0';
    }
}