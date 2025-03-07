class Solution {
    public int[] closestPrimes(int left, int right) {
         return solve(left, right);
    }
    public  int[] solve(int start, int end) {
        boolean[] flag = new boolean[(end) + 1];
        int s = 2, limit = (int) Math.sqrt(end);
        int index = start, temp = start;
        flag[0] = true;
        for (int i = 2; i <= limit; i++){
            if (!flag[i]){
                for (int j = i + i; j <= end; j = j + i){
                    if (j % i == 0)
                          flag[j] = true;
                }
            }
        }
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int pre = -1, min = Integer.MAX_VALUE;
        if (start == 1)
           start = 2;
        for (int i =  start; i <= end; i++) {
            if (!flag[i]) {
                int d = i - pre;
                if (d < min) {
                    min = d;
                    ans[0] = pre;
                    ans[1] = i;
                }
                pre = i;
            } else if (!flag[i]) pre = i;
        }

        if (ans[0] == -1 || ans[1] == -1){
            ans[0] = -1; ans[1] = -1;
        }
        return ans;
    }
}