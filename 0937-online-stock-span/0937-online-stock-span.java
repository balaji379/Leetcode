class StockSpanner {
    Stack<Integer> stack;
    ArrayList<Integer> span;
    ArrayList<Integer> arr;
    public StockSpanner() {
        stack = new Stack<>();
        span = new ArrayList<>();
        arr = new ArrayList<>();
    }
    
    public int next(int price) {
        arr.add(price);
        if (stack.isEmpty()){
            span.add(1);
            stack.push(span.size() - 1);
        }else if (price >= arr.get(stack.peek())){
            int count = 0;
             while (!stack.isEmpty() && price >= arr.get(stack.peek())){
                count += span.get(stack.pop());
             }
             span.add(count + 1);
             stack.push(arr.size() - 1);
        }else {
            span.add(1);
            stack.push(arr.size() - 1);
        }
        return span.get(span.size() -1);
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */