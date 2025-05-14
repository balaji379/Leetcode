class Solution {
    static  final int mod = (int)(Math.pow(10,9) + 7);
    public int modvalue(int a,int b){
        a += b;
        if (a >= mod)  return a %= mod;
        else return a;
    }
    public int lengthAfterTransformations(String s, int t) {
        int[] count = new int[26];
        for (char c : s.toCharArray())
           count[c-'a'] += 1;
       for (int i = 0; i < t; i++){
          int[] newcount = new int[26];
          for (int j = 0; j < 26; j++){
            if (j < 25){
                 newcount[j + 1] = count[j];
            }
            else{
                 newcount[0] += count[j];
                 newcount[1] = modvalue(newcount[1],count[j]);
            }
          }
          count = newcount;
       }
       int val = 0;
       for (int c : count)
          val = modvalue(val,c);
        //   System.out.println(val);
       return val;
    }
}