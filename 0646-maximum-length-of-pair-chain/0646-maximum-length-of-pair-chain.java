class Solution {
    public int findLongestChain(int[][] pairs) {
         return solve(pairs).size();
        
    }

    public  List<int[]> solve(int[][] mat) {
        Arrays.sort(mat, (a, b) -> a[0] - b[0]);
        int index = 1, len = mat.length;
        List<int[]> list = new LinkedList<>();
        list.add(mat[0]);
        while (index < len) {
            int[] f = list.getLast();
            int[] s = mat[index];
            if (f[1] < s[0]) {
                list.add(s);
            } else {
                if (s[1] < f[1]) {
                    list.removeLast();
                    list.add(s);
                }
            }
            index += 1;
        }

        return list;
    }
}
