class Solution {
    public int minimumLength(String s) {
        return reduceStringLength(s);
    }
    public  int reduceStringLength(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        return map.values().stream().map(a -> {
            if (a % 2 == 0)
                return 2;
            else return 1;
        }).reduce((a, b) -> a + b).get();
    }
}