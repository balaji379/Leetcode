class Solution {
    public int countMaxOrSubsets(int[] nums) {
        List<List<Integer>> list = subset(nums);
        int maxor = 0, count = 0;
        for (int val : nums)
            maxor |= val;
        for (List<Integer> innerlist : list) {
            int sum = 0;
            for (int val : innerlist) {
                sum |= val;
            }
            if (sum == maxor)
                count += 1;
        }
        return count;
    }

    public List<List<Integer>> subset(int... arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int val : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> interval = new ArrayList<>(outer.get(i));
                interval.add(val);
                outer.add(interval);
            }
        }
        return outer;
    }
}