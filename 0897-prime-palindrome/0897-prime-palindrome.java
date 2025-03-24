class Solution {
    public int primePalindrome(int n) {
        if (n == 1)
           return 2;
         while (true){
            if (n > 1000 && n < 10000 ||
                n > 100000 && n < 1000000 ||
                n > 10000000 && n < 100000000){
                    n = (int)Math.pow(10,Math.ceil(Math.log10(n)));
                    continue;
                }
            if (isprime(n) && ispalidrome(n))
               return n;
            n += 1;
         }
        //  return -1;
    }
    public boolean isprime(int n){
        for (int i =2; i <= Math.sqrt(n); i++){
            if (n % i == 0)
               return false;
        }
        return true;
    }
    public boolean ispalidrome(int n){
        String s = String.valueOf(n);
        int start = 0 , end = s.length() - 1;
        while (start <= end){
            if (s.charAt(start) == s.charAt(end)){
                start += 1;
                end -= 1;
            }
            else return false;
        }
        return true;
    }
}