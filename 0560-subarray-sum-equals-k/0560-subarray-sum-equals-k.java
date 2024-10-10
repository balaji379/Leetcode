class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0 , sum = 0;
        for( int val : nums ){
            sum += val;
            if( sum == k)
               count += 1;
            if( map.containsKey(sum - k) )
               count += map.get( sum - k );
            map.put(sum , map.getOrDefault( sum , 0) + 1); 
        }
  return count;
    }
}