class Solution {
    public int triangularSum(int[] nums) {
         List<Integer> list = new ArrayList<>();
         for (int i : nums)
            list.add(i);
        while (list.size() > 1){
            List<Integer> temp = new ArrayList<>();
            int len = list.size();
            for(int i = 0; i < len - 1; i++){
                temp.add((list.get(i) + list.get(i+1)) % 10);
            }
            list = temp;
        }
        return list.get(0);
    }
}