class Solution {
    public List<Integer> grayCode(int n) {
         List<Integer> list = new ArrayList<>();
         list.add(0);
         if (n > 0)
           list.add(1);
        int cur = 1;
         for (int i = 2; i <= n; ++i){
            cur *= 2;
            for (int j = list.size() - 1; j >= 0; --j){
                list.add(list.get(j) + cur);
            }
         }
         return list;
    }
}