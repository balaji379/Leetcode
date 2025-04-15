class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Double> q = new PriorityQueue();
        Map<Double,int[]> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
              double a = arr[i];
            for (int j = i + 1; j < arr.length; j++){
              double b = arr[j];
              double d = a / b;
              int[] temp = new int[2];
              temp[0] = arr[i];
              temp[1] = arr[j];
              map.put(d,temp);
              q.add(d);
            }
        }
        int[] ans = new int[2];
        // System.out.println(q);
        // for (double val : q){
        //     System.out.println(val + "arr : " + Arrays.toString(map.get(val)));
        // }
        while (!q.isEmpty() && k > 0){
           ans = map.get(q.poll());
        //    System.out.println(Arrays.toString(ans));
           k -= 1;
        }
    
        return ans;
    }
}