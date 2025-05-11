
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    Map<Integer,Integer> map = new HashMap<>();
    int size = 0;
    public List<List<Integer>> permuteUnique(int[] nums) {
         for (int val : nums)
            map.put(val,map.getOrDefault(val,0) + 1);
         this.size = nums.length;
         solve();
         return list;
        
    }  
    public void solve(){
        if (temp.size() == size){
            list.add(new ArrayList<>(temp));
            return;
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            if (val == 0)
               continue;
            temp.add(key);
            map.put(key,val - 1);
            solve();
            temp.removeLast();
            map.put(key,val);
        }
    }
}