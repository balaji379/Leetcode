class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
          double max = 0,min = 1;
          for (int val : quantities){
            max = Math.max(val,max);
          }
          double ans = max;
        while(min <= max){
            double mid = (int)(min + max) / 2;
            int total = 0;
            for (int val : quantities){
                total += (int)Math.ceil(val / mid);
            }
            if (total == n){
                ans = Math.min(ans,mid);
                max = mid - 1;
            }
           else if (total < n){
                ans = Math.min(ans,mid);
                max = mid - 1;
            }
            else min = mid + 1;
        }
        return (int)ans;
    }
}