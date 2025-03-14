class RangeFreqQuery {
    private HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            }
        }
    }

    public int query(int left, int right, int value) {
        ArrayList<Integer> list = map.get(value);
        if (list == null)
            return 0;
        int start = findTarget(list, left, true);
        int end = findTarget(list, right, false);
        if (start == -1 || end == -1)
            return 0;
        if (list.get(start) >= left && list.get(end) <= right) {
            return (end - start) + 1;
        }
        return 0;
    }

    public int findTarget(ArrayList<Integer> list, int target, boolean flag) {

        int start = 0, end = list.size() - 1, res = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) == target)
                return mid;
            else if (list.get(mid) > target) {
                if (flag)
                    res = mid;
                end = mid - 1;
            } else {
                if (!flag)
                    res = mid;
                start = mid + 1;
            }
        }
        return res;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */