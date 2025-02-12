class Solution {
    public int maximumSum(int[] nums) {
         Map<Integer,PriorityQueue> map = new HashMap<>();
         for (int i = 0; i < nums.length; i++){
            int temp = nums[i];
            int sum = 0;
            while (temp != 0){
                sum += (temp % 10);
                temp /= 10;
            }
            if (map.containsKey(sum))
                 map.get(sum).add(nums[i]);
            else {
                PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
                queue.add(nums[i]);
                map.put(sum,queue);
            }
         }
         int max = 0;
         for (PriorityQueue<Integer> q : map.values()){
            if (q.size() >= 2){
                 int first = q.poll();
                 int second = q.poll();
                 max = max > (first + second) ? max :(first + second);
            }
         }
         return max == 0 ? -1 : max;
    }
}