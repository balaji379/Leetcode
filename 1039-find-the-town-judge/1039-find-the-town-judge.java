class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 1) return 1;
        int[] num = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            num[trust[i][0]] -= 1;
            num[trust[i][1]] += 1;
        }
        for (int i = 0; i < num.length; i++) {
            if(num[i] == n - 1){
                return i;
            }
        }
        return -1;
    }
}