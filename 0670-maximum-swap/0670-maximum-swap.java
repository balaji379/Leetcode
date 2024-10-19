class Solution {
    public int maximumSwap(int num) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int val = num;
        while (val != 0) {
            int v = val % 10;
            queue.add(v);
            list.addFirst(v);
            val /= 10;
        }
        int index = 0;
        for (int v : list) {
            map.put(v, index);
            index += 1;
        }
        for (int i = 0; i < list.size(); i++) {
            int n = queue.poll();
            if (list.get(i) < n) {
                index = map.get(n);
                list.set(index, list.get(i));
                list.set(i, n);
                break;
            }
        }
        index = list.size();
        int pow = (int) Math.pow(10, index);
        num = 0;
        while (!list.isEmpty()) {
            pow /= 10;
            num += ((list.removeFirst()) * pow);
        }
        return num;
    }
}