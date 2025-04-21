class Solution {

    Map<Integer, Integer> dp = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
       Map<Integer, Integer> map = new HashMap<>();
       List<Integer> list = new ArrayList<>();
      
        for (int i = lo; i <= hi; i++) {
            map.put(i, solve(i));
            list.add(i);
        }
        Collections.sort(list,(a,b)->{
              if (map.get(a) == map.get(b))
                  return a - b;
              else return map.get(a) - map.get(b);
        });
    
        return list.get(k-1);
    }

    public int solve(int val) {

        if (val == 1) {
            return 0;
        }

        if (dp.containsKey(val))
            return dp.get(val);

        int count = 0;

        if (val % 2 == 0) {
            count = 1 + solve(val / 2);
        } else {
            count = 1 + solve((3 * val) + 1);
        }
        dp.put(val, count);
        return count;
    }
}