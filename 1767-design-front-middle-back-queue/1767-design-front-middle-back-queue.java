class FrontMiddleBackQueue {
    public LinkedList<Integer> q;
    public FrontMiddleBackQueue() {
        this.q = new LinkedList<>();
    }
    
    public void pushFront(int val) {
        q.addFirst(val);
    }
    
    public void pushMiddle(int val) {
        int mid = (q.size() / 2);
        q.add(mid,val);
    }
    
    public void pushBack(int val) {
         q.add(val);
    }
    
    public int popFront() {
        if (q.isEmpty())
           return -1;
         return q.removeFirst();
    }
    
    public int popMiddle() {
        if (q.isEmpty())
           return -1;
           int len = q.size();
           if (len % 2 == 0)
             len -= 1;
         int mid = (len  / 2);
         return q.remove(mid);
    }
    
    public int popBack() {
        if (q.isEmpty())
           return -1;
         return q.removeLast();
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */