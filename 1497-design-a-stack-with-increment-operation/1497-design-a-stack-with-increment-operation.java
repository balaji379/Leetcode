class CustomStack {
        int[] stack;
        int index;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        index = 0;
    }
    
    public void push(int x) {
          if( index < stack.length ){
               stack[index] = x;
               index += 1;
          }
    }
    
    public int pop() {
          if( index > 0 ){
            int out = stack[index - 1];
            index -= 1;
            return out;
          }
          return -1;
    }
    
    public void increment(int k, int val) {
          for( int i = 0; i < k && i < stack.length; i++){
            stack[i] += val;
          }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */