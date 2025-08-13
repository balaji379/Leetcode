public class RecentCounter {
    Queue<int> q = new Queue<int>();
    public RecentCounter() {
        
    }
    
    public int Ping(int t) {
        int time = t - 3000;
        if (q.Count <= 0){
            q.Enqueue(t);
        }
        else {
            while (q.Count > 0 && q.Peek() < time){
                  q.Dequeue();
            }
            q.Enqueue(t);
        }
        return q.Count;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.Ping(t);
 */