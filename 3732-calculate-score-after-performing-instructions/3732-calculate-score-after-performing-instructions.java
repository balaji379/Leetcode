class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        int i = 0, n = values.length;
        long sum = 0;
        boolean[] vis = new boolean[instructions.length];
        while(i >= 0 && i < n && i < instructions.length){
            if(vis[i]) break;
            else if(instructions[i].equals("add")){
                sum += values[i];
                vis[i] = true;
                i++;
            }else{
                vis[i] = true;
                i += values[i];
            }
        }
        return sum;
    }
}