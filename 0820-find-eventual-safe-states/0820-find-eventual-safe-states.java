class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
      boolean[] dp = new boolean[graph.length];
          boolean[] visitedPath = new boolean[dp.length];
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            findSafeNode(graph, i, answer, visitedPath, dp);
        }
        Collections.sort(answer);
        return answer;
    }
    public static boolean findSafeNode(int[][] graph,int node,List<Integer> answer,boolean[] visited,boolean...dp){
       if (visited[node])
            return false;

        if (dp[node])
            return true;

        boolean flag = true;
        for (int i = 0; i < graph[node].length; i++){
            visited[node] = true;
             boolean subout = findSafeNode(graph,graph[node][i],answer,visited,dp);
             if (!subout){
                 flag = false;
                 dp[node] = false;
                 break;
             }
        }
        visited[node] = false;
        if (flag) {
            answer.add(node);
            dp[node] = true;
        }
        return dp[node];
    }
}