class Solution {
    public int findJudge(int n, int[][] trust) {
        Set<Integer> set = new HashSet<>();
        if (n == 1 ) 
          return 1;
        if( trust.length == 0 )
           return -1;
        int judge = trust[0][1];
        boolean flag = true;
        for(int i = 1; i <= trust.length; i++){
            set.add(trust[i-1][0]);
        }
        System.out.print(set);
        int count = 0,j = 0;
       for (int i = 1; i<= n; i++){
        if(!set.contains(i))
            count += 1;
            j = i;
       }
    
        return (count == 1 ? (j == judge ? j : -1) : -1) ;
    }
}