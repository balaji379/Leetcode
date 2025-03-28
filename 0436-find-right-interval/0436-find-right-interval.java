class Solution {
     List<Integer> start = new ArrayList<>();
     Map<Integer,Integer> map = new HashMap<>();
    public int[] findRightInterval(int[][] intervals) {

        for (int i = 0; i < intervals.length; i++) {
            start.add(intervals[i][0]);
            map.put(intervals[i][0],i);
        }
        Collections.sort(start);
        int[] ans = new int[intervals.length];
        int len = start.size();
        for (int i = 0; i < len; i++){
            ans[i] = isPresent(intervals[i][1],ans.length);
        }
        return ans;
    }
    public int isPresent(int target,int len){
        int l = 0 , r =  len - 1;
        int ans = Integer.MAX_VALUE;
        while(l <= r){
            int mid = (l + r)  / 2;
            if (start.get(mid) >= target){
                ans = map.get(start.get(Math.min(ans,mid)));
                r = mid - 1;
            }else l = mid + 1;
        }
        if (ans == Integer.MAX_VALUE)
             return -1;
        return ans;
    }
}