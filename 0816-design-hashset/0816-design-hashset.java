class MyHashSet {
  public int size ;
  public int[] hashtable;
    public MyHashSet() {
        size = 9;
        hashtable = new int[size];
    }
    public void extendSize(int key){
        int[] temp = new int[key*2];
        size = key*2;
        for(int i =0 ;i<hashtable.length;i++)
          temp[i] = hashtable[i];
        temp[key]  = key;
        hashtable = temp ;
    }
    public void add(int key) {
          if(key==0){
            hashtable[key] = 1;
          }else{
            if(size>key){
                hashtable[key] = key;
            }else{
                extendSize(key);
            }
          }

    }
    
    public void remove(int key) {
         if(key==0)
            hashtable[0] = -1;
        else{
           if(size>key)
             hashtable[key] = -1;
        }
    }
    
    public boolean contains(int key) {
        if(key==0)
            if(hashtable[0]==1)
               return  true;
            else
             return false;
        else if(size>key){
             if(hashtable[key]==key)
               return true;
            else return false;
        }else return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */