class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        combination(answer, list, n, k, 0, set);
        return answer;
    }
    public static void combination(List<List<Integer>> answer, List<Integer> list, int n, int k, int index,
            Set<String> set) {
        if (list.size() == k) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            String str = temp.toString();
            if (!set.contains(str)) {
                answer.add(temp);
                set.add(str);
            }
            list.removeLast();
        }
        if (index > n)
            return;

        List<Integer> combination = new ArrayList<>();

        for (int i = index + 1; i <= n; i++) {
            combination.add(i);
        }
        for (int val : combination) {
            list.add(val);
            combination(answer, list, n, k, val, set);
            if (!list.isEmpty() && list.getLast() == val)
                list.removeLast();
        }
        return;
    }
}