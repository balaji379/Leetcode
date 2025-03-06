class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] count = new int[(grid.length * grid.length)+ 1];
        int r = -1, m = -1,sum = 0;
        for(int[] val : grid){
                for (int v : val)
                   count[v] += 1;
        }
        for (int i = 1; i <= count.length; i++){
            if (count[i] == 0)
               m = i;
            if (count[i] > 1)
               r = i;
            if (m != -1 && r != -1)
               break;
        }
        int[] ans = new int[2];
        ans[0] = r;
        ans[1] = m;
        return ans;
    }
}