class ProductOfNumbers {
         List<Integer> list ;
         List<Integer> prefix;
         int lastZero = -1;
    public ProductOfNumbers() {
          this.list = new ArrayList<>();
          this.prefix  = new ArrayList<>();
          prefix.add(1);
    }
    
    public void add(int num) {
        list.add(num);
        int last = prefix.getLast();
        if (last != 0)
           prefix.add(last * num);
        else {
           lastZero = prefix.size() - 1;
           prefix.add(num);
           
        }
    }
    
    public int getProduct(int k) {
          int end = prefix.getLast();
          int startIndex = (prefix.size()-1)-k;
         
          if (startIndex < lastZero)
              return 0;
          else if (prefix.get(startIndex) == 0)
               return end;
          else 
             return end / prefix.get(startIndex);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */