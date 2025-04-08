class Solution {
    public int minimumOperations(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int val : nums)
            list.add(val);
        int min = 0;

        while (!list.isEmpty()) {
            Set<Integer> set = new HashSet<>();
            boolean flag = true;
            for (int val : list) {
                if (!set.contains(val))
                    set.add(val);
                else {
                    int i = 0;
                    while (!list.isEmpty() && i < 3) {
                        list.removeFirst();
                        i += 1;
                    }
                    flag = false;
                    min += 1;
                    break;
                }
            }
            if (flag)
                return min;
        }
        return min;
    }
}