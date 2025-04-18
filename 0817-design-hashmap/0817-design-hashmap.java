class MyHashMap {
   int[] map ;
   boolean[] flag;
    public MyHashMap() {
         map = new int[10000000];
         flag = new boolean[10000000];
    }
    
    public void put(int key, int value) {
        map[key] = value;
        flag[key] = true;
    }
    
    public int get(int key) {
        if (flag[key]) 
           return map[key];
        else return -1;
    }
    
    public void remove(int key) {
        flag[key] = false;
        map[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */