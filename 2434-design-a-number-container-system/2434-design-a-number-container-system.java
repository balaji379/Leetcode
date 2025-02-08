class NumberContainers {
             Map<Integer,TreeSet<Integer>> value;
             Map<Integer,Integer> index;
    public NumberContainers() {
         value = new HashMap<>();
         index = new HashMap<>();
    }
    
    public void change(int ind, int number) {
           if (index.containsKey(ind)){
           int replaceVal = index.get(ind);
           if (value.containsKey(replaceVal)){
                Set<Integer> old = value.get(replaceVal);
                old.remove(ind);
                if (old.size() == 0)
                    value.remove(replaceVal);
                index.put(ind,number);
                if(value.containsKey(number))
                     value.get(number).add(ind);
                else{
                    TreeSet<Integer> i = new TreeSet<>();
                    i.add(ind);
                    value.put(number,i);
                }
           }
           }else{
            index.put(ind,number);
            if (value.containsKey(number))
                value.get(number).add(ind);
            else{
                  TreeSet<Integer> i = new TreeSet<>();
                    i.add(ind);
                    value.put(number,i);
            }
           }
    }
    
    public int find(int number) {
           if (value.containsKey(number)){
            return value.get(number).getFirst();
           }
           else return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */