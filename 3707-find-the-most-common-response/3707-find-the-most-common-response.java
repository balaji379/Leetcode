class Solution {
    public String findCommonResponse(List<List<String>> responses) {

        List<HashSet<String>> ques = new ArrayList<>();
        for (List<String> i : responses) {
            HashSet<String> temp = new HashSet<>(i);
            ques.add(temp);
        }

        ArrayList<HashMap<String, Integer>> list = new ArrayList<>();
        for (HashSet<String> i : ques) {
            HashMap<String, Integer> map = new HashMap<>();
            for (String j : i) {
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
            list.add(map);
        }
        HashMap<String, Integer> ans = new HashMap<>();
        for (HashMap<String, Integer> i : list) {
            for (String j : i.keySet()) {
                int val = i.get(j);
                ans.put(j, ans.getOrDefault(j, 0) + val);
            }
        }

        int max = Integer.MIN_VALUE;
        String s = "";
        for (String i : ans.keySet()) {
            int num = ans.get(i);
            if (max < num) {
                max = num;
                s = i;
            } else if (max == num && i.compareTo(s) < 0) {
                max = num;
                s = i;
            }
        }
        return s;
    }
}