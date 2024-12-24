class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        Permutation(temp,answer,0,nums);
        return answer;
    }
     public static void Permutation(List<Integer> temp , List<List<Integer>> answer,int index,int...nums){
        if (nums.length - index == 0){
            answer.add(temp);
            return ;
        }
        int len =  temp.size();
        for (int i = 0; i <= len; i++){
            List<Integer> nextReg = new LinkedList<>();
            nextReg.addAll(temp);
            nextReg.add(i,nums[index]);
            Permutation(nextReg,answer,index + 1,nums);
        }
    }
}