class Solution {
    public int countPrimes(int n) {
    if (n == 0 || n == 1 || n == 2)
       return 0;
    boolean[] flag = new boolean[n];
    flag[0] = true;
    flag[1] = true;
    for (int i = 2; i <= Math.sqrt(n); i++){
        if (!flag[i]){
             for(int j = i + i; j < n; j = j + i){
                flag[j] = true;
             }
        }
    }
    int count = 0;
    // System.out.println(Arrays.toString(flag));
    for(int i = 0; i < n; i++){
       if (!flag[i])
          count += 1;
    }
    return count;
    }
    
}