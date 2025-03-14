class Solution {
    public int maximumCandies(int[] candies, long k) {
        long start = 1,max = 0,sum = 0;
        long end = 0;
        for (int val : candies){
            end = Math.max(val,end);
            sum += val;
        }
        if (sum == k)
            return 1;
        else if (sum < k)
           return 0;
        while (start <= end){
             long mid = (end + start) / 2;
             boolean flag = isDistribute(mid,k,candies);
             if (flag){
                max = Math.max(max,mid);
               start = mid + 1;
             }
             else end = mid - 1;
        }
        return (int)max;
    }
    public boolean isDistribute(long c, long k , int...nums){
        long sum = 0;
         for (int val : nums){
            sum += (val / c);
         }
         if (sum >= k)
            return true;
        return false;    
    }
}