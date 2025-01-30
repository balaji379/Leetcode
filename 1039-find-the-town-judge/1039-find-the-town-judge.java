class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0 && n < 1)
           return -1;
        if (trust.length == 0 && n > 1)
           return -1;
        if (n == 1)
           return 1;
        Map<Integer,Integer>  ajudge = new HashMap<>();
        Map<Integer,Integer>  notajudge = new HashMap<>();
        for (int[] judge : trust){
           ajudge.put(judge[1],0);
           notajudge.put(judge[0],0);
        }
        for (int[] judge : trust){
            ajudge.put(judge[1] ,ajudge.get(judge[1])+1);
            if (ajudge.get(judge[1]) == n -1 && !notajudge.containsKey(judge[1]))
               return judge[1];
        }
        return -1;
    }
}