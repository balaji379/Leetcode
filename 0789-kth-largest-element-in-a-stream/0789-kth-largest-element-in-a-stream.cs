public class KthLargest {
    List<int> list = new List<int>();
    int k;
    public KthLargest(int k, int[] nums) {
        foreach(int val in nums)
           list.Add(val);
        list.Sort();
        this.k = k;
    }
    
    public int Add(int val) {
        int pos = Search(list,val);
        list.Insert(pos,val);
        int len = list.Count;
        return list[len - k];
    }
    public int Search(List<int> list,int key){
        int left = 0 , right = list.Count - 1;
        while (left <= right){
            var mid = (right + left) / 2;
            if (list[mid] <= key){
                left = mid + 1;
            }else right = mid - 1;
        }
        return left;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.Add(val);
 */