class Solution {
    public int removeStones(int[][] stones) {
        Map<Integer, Integer> parent = new HashMap<>();

        // Union the row and column, offset y to avoid overlap
        for (int[] stone : stones) {
            int x = stone[0];
            int y = ~stone[1]; // Use ~y to differentiate row and column
            union(x, y, parent);
        }

        Set<Integer> uniqueRoots = new HashSet<>();
        for (int[] stone : stones) {
            uniqueRoots.add(find(stone[0], parent));
        }

        return stones.length - uniqueRoots.size();
    }

    private int find(int x, Map<Integer, Integer> parent) {
        if (!parent.containsKey(x)) parent.put(x, x);
        if (x != parent.get(x)) parent.put(x, find(parent.get(x), parent));
        return parent.get(x);
    }

    private void union(int x, int y, Map<Integer, Integer> parent) {
        parent.putIfAbsent(x, x);
        parent.putIfAbsent(y, y);
        parent.put(find(x, parent), find(y, parent));
    }
}
