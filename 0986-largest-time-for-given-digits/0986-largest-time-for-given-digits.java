class Solution {
    StringBuilder time = new StringBuilder();
    Map<Integer, Integer> map = new HashMap<>();
    int h = -1, min = -1;

    public String largestTimeFromDigits(int[] arr) {

        for (int c : arr)
            map.put(c, map.getOrDefault(c, 0) + 1);
        solve(arr.length);
        if(h == -1 || min == -1)
          return "";
        String hh = String.valueOf(h);
        String mm = String.valueOf(min);
        if (hh.length() < 2)
            hh = "0" + hh;
        if (mm.length() < 2)
            mm = "0" + mm;
        return hh + ":" + mm;
    }

    public void solve(int len) {
        if (time.length() == len) {
            String t = time.toString();
            int hh = Integer.parseInt(t.substring(0, 2));
            int mm = Integer.parseInt(t.substring(2, 4));
            if (hh < 24 && mm < 60 && hh > h) {
                h = hh;
                min = mm;
            } else if (hh == h) {
                if (mm < 60 && min < mm)
                    min = mm;
            }
            return;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val != 0) {
                time.append(key);
                map.put(key, val - 1);
                solve(len);
                time.deleteCharAt(time.length() - 1);
                map.put(key, val);
            }
        }
    }
}