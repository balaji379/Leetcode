class Solution {
    public int climbStairs(int n) {
           int step =0,itr = 2,first =1,second=1,sum=0;
           if(n==1) return n;
           else{
            while(itr<=n){
                  sum=first+second;
                  if(itr==n)
                      return sum;
                  else {
                    first=second;
                    second=sum;
                  }
                  itr++;
            }
           }
           return 0;
    }
}