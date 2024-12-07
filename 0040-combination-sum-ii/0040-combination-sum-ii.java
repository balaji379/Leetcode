class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<Integer> list = new LinkedList<>();
        List<List<Integer>> answer = new LinkedList<>();
        Arrays.sort(candidates);
        combinationSum(0, candidates, list, answer, 0,target);
        return answer;
    }

     public static int combinationSum(int cInd, int[] arr, List<Integer> list, List<List<Integer>> answer, int sum,
            int target) {
        if (sum >= target)
            return list.removeLast();
        for (int i = cInd; i < arr.length; i++) {
            if (i > cInd && arr[i] == arr[i -1])
                continue;
            sum += arr[i];
            list.add(arr[i]);
            if (sum == target) {
                List<Integer> l = new LinkedList<>();
                l.addAll(list);
                // System.out.println(l);
                answer.add(l);
            }
            int remove = combinationSum(i + 1, arr, list, answer, sum, target);
            sum -= remove;

        }

        return !list.isEmpty() ? list.removeLast() : 0;

}
}