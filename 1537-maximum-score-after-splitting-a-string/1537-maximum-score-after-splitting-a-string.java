class Solution {
    public int maxScore(String s) {
        int[] zeroPrefix = new int[s.length()];
        int[] onePrefix = new int[s.length()];
        int zero = 0, one = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '0'){
                zero += 1;
                zeroPrefix[i] = zero;
                onePrefix[i] = one;
            }
             if (s.charAt(i) == '1'){
                one += 1;
                onePrefix[i] = one;
                zeroPrefix[i] = zero;
            }
        }
         int max = -1;
        if (one == 0 || zero == 0 )
            getAnswer(s);
        for (int i = 0; i < s.length() - 1; i++){
            int sum = zeroPrefix[i] + (one - onePrefix[i]);
            max = Math.max(sum,max);
        }
    
        return max;
    }
    public static int getAnswer(String s){
      if (s.length() == 2)
                return 1;
             int sum = s.length() / 2;
             if ((s.length() - sum) - sum == 0) {
                return sum + 1;
            }
           else return sum + 2;   
    }
}