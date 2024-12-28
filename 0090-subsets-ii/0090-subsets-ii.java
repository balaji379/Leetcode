class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Subset(temp, answer, 0, nums, visited);
        return answer;
    }

    public static void Subset(List<Integer> list, List<List<Integer>> answer, int index, int[] nums, Set<String> visited) {
        String str = list.toString();
        if (visited.contains(str))
            return ;
        else {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            answer.add(temp);
            visited.add(str);
            while (index < nums.length) {
                list.add(nums[index]);
                index += 1;
                Subset(list, answer, index, nums, visited);
                if (!list.isEmpty())
                    list.removeLast();
            }
        }
    }
}