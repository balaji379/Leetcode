class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    int count = 0;
    List<Integer> list = new ArrayList<>();
    public int countArrangement(int n) {
           for (int i = 1; i <= n; i++)
              map.put(i,1);
              solve(n);
              return count;
            
    }
    public void solve(int n){
       
       if (n <= 0){
        count += 1;
        return;
       }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            if (val != 0){
                int i = list.size() + 1;
                
                if (key % i == 0){
                    list.add(key);
                    map.put(key,val - 1);
                    solve(n - 1);
                    list.remove(list.size() - 1);
                    map.put(key,val);
                }else if (i % key == 0){
                     list.add(key);
                    map.put(key,val - 1);
                    solve(n - 1);
                    list.remove(list.size() - 1);
                    map.put(key,val);
                }
            }
        }

    }

}