class CombinationIterator {
    List<String> list = new ArrayList<>();
    public CombinationIterator(String characters, int combinationLength) {
         solve("",characters,combinationLength);
         System.out.println(list);
    }
    
    public String next() {
        return list.removeFirst();
    }
    
    public boolean hasNext() {
        return !list.isEmpty();
    }
    public void solve(String p, String up,int size){
        if (up.isEmpty() || p.length() >= size){
            if (p.length() == size)
               list.add(p);
            return;
        }
        int len = up.length();
            String s = up.substring(1);
            solve(p + up.charAt(0),s,size);
            solve(p,s,size);
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */