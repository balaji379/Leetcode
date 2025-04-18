class MyHashMap {
   List<Integer> key;
   List<Integer> value;
    public MyHashMap() {
        key = new ArrayList<>();
        value = new ArrayList<>();
    }
    
    public void put(int key, int value) {
       if (this.key.contains(key)){
          int target = this.key.indexOf(key);
          this.value.set(target,value);
       }else{ 
           this.key.add(key);
           this.value.add(value);
       }
    }
    
    public int get(int key) {
        if (this.key.indexOf(key) > -1){
            return value.get(this.key.indexOf(key));
        }
        return -1;
    }
    
    public void remove(int key) {
        int target = this.key.indexOf(key);
        if (target > -1){
           this.key.remove(target);
           value.remove(target);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */