class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] count = new int[n];
        for(List<Integer> i: edges){
            count[i.get(1)]++;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(count[i] == 0) ans.add(i);
        }
        return ans;
    }
}