class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int[] ans = new int[queries.length];
        ArrayList<Integer> list = new ArrayList<>();
        int pow = 0;
        while(n > 0){
            if((n&1) == 1){
                list.add((int)(Math.pow(2,pow)));
            }
            n>>=1;
            pow++;
        }
        int idx = 0;
        for(int[] i: queries){
            long prod = 1;
            for(int j = i[0]; j <= i[1]; j++){
                prod =(prod * list.get(j)) % (int)(1e9+7);
            }
            ans[idx++] = (int)(prod);
        }
        return ans;
    }
}