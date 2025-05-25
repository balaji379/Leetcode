class Solution {
 public  int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        int oddcount = 0;
        int len = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int val = entry.getValue();
            if (val > 0) {
                String rkey = key.substring(1) + key.substring(0, 1);
                if (key.equals(rkey)) {
                    int rval = map.get(rkey);
                    if (rval % 2 != 0 && oddcount == 0){
                        oddcount = 1;
                        len += (val * 2);
                    }else if (rval % 2 != 0){
                        len += ((rval - 1) * 2);
                    }
                    else if (rval % 2 == 0){
                        len += (rval * 2);
                    }
                    map.put(key, 0);
                }
                else if (map.containsKey(rkey)) {
                    len += (Math.min(val, map.get(rkey)) * 4);
                    map.put(key, 0);
                    map.put(rkey, 0);
                }
            }
        }
        return len;
    }
}