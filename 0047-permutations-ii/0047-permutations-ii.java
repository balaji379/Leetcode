class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Permutation(temp,answer,0,set,nums);
        return answer;
    }
    public static void Permutation(List<Integer> temp , List<List<Integer>> answer,int index,Set<String> set,int...nums){
        if (nums.length - index == 0){
            String str = temp.toString();
            if (!set.contains(str)){
                answer.add(temp);
                set.add(str);
            }
            return ;
        }
        int len =  temp.size();
        for (int i = 0; i <= len; i++){
            List<Integer> nextReg = new LinkedList<>();
            nextReg.addAll(temp);
            nextReg.add(i,nums[index]);
            Permutation(nextReg,answer,index + 1,set,nums);
        }
    }
}