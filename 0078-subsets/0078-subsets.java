class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new LinkedList<>();
        List<List<Integer>> answer = new ArrayList<>();
        Subset(temp,answer,0,nums);
        return answer;
    }
    public static  void Subset(List<Integer> list, List<List<Integer>> answer ,int index ,int[] nums){
        List<Integer> temp = new ArrayList<>();
        temp.addAll(list);
        answer.add(temp);
        while (index < nums.length) {
            list.add(nums[index]);
            index += 1;
            Subset(list,answer,index,nums);
            if (!list.isEmpty())
                list.removeLast();
        }
    }
}