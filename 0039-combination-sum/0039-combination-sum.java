class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        combinationSum(0,candidates,list,answer,0,target);
        return answer;
    }
    public static int combinationSum(int i, int[] arr, List<Integer> list, List<List<Integer>> answer, int sum,
            int target) {
        if (sum >= target)
            return list.removeLast();
        for (i = i; i < arr.length; i++) {
            sum += arr[i];
            list.add(arr[i]);
            if (sum == target) {
                List<Integer> l = new LinkedList<>();
                l.addAll(list);
                answer.add(l);
            }
            int remove = combinationSum(i, arr, list, answer, sum, target);
            sum -= remove;
        }

        return !list.isEmpty() ? list.removeLast() : 0;

    }
}
