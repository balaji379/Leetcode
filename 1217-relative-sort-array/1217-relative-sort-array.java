class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
         List<Integer> list = new ArrayList<>();
         Map<Integer,Integer> map = new HashMap<>();
         Map<Integer,Integer> notpresent = new HashMap<>();
         Arrays.sort(arr1);
         for (int val : arr2){
            map.put(val,0);
         }
         for (int val : arr1){
            if (map.containsKey(val)){
                map.put(val,map.get(val) + 1);
            }
            else notpresent.put(val,notpresent.getOrDefault(val,0) + 1);
         }
         for (int val : arr2){
             for (int i = 0; i < map.get(val); i++)
                list.add(val);
         }
         for (int val : arr1){
            if (notpresent.containsKey(val) && notpresent.get(val) != 0){
                for (int i = 0; i < notpresent.get(val); i++)
                   list.add(val);
                notpresent.put(val,0);
            }
         }
         int[] ans = new int[list.size()];
         for (int i = 0; i < ans.length; i++)
           ans[i] = list.get(i);
        return ans;
    }
}