class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> list = new LinkedList<>();
        List<List<Integer>> answer = new LinkedList<>();
        Set<String> set = new HashSet<>();
        nonDecreasingSubsequences(0,list,answer,set ,nums);
        return answer;
    }
    public static void nonDecreasingSubsequences(int start, List<Integer> list, List<List<Integer>> answer, Set<String> set, int...nums){
        if (start > nums.length)
             return;
        if (!list.isEmpty() && list.size() >= 2){
            String str = list.toString();
            if (!set.contains(str)) {
                List<Integer> temp = new ArrayList<>(list);
                answer.add(temp);
                set.add(str);
            }
        }
        for (int i = start; i < nums.length; i++) {
            if (list.isEmpty())
                 list.add(nums[i]);
            else {
                if (list.getLast() > nums[i])
                     continue;
                else{
                    list.add(nums[i]);
                }
            }
            nonDecreasingSubsequences(i + 1,list,answer,set,nums);
            list.removeLast();
        }


    }
}
