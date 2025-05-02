class Solution {
    public int largestRectangleArea(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        solve(new Stack<>(),arr,left,true,0);
        solve(new Stack<>(),arr,right,false,arr.length - 1);
        int max = 0;
        for (int i = 0; i < arr.length; i++){
            int leftsmall = left[i];
            int rightsmall = right[i];
            if (leftsmall == -1)
               leftsmall = 0;
            else leftsmall += 1;
            
            if (rightsmall == -1)
               rightsmall = arr.length - 1;
            else rightsmall -= 1;
            
            int bars = (rightsmall - leftsmall) + 1;
            max = Math.max(max,arr[i] * bars);
        }
        return max;
    }
    public  void solve (Stack<Integer> stack,int[] arr,int[] r,boolean flag,int start){
        int i = start;
        while ((flag ? i < arr.length : i >= 0)){
             if (stack.isEmpty()){
                 stack.push(i);
                 r[i] = -1;
             }else if (arr[i] <= arr[stack.peek()]){
                  while (!stack.isEmpty() && arr[i] <= arr[stack.peek()])
                      stack.pop();
                  if (stack.isEmpty()){
                      r[i] = -1;
                      stack.push(i);
                  }else{
                      r[i] = stack.peek();
                      stack.push(i);
                  }
             }
             else {
                 r[i] = stack.peek();
                 stack.push(i);
             }
             if (flag)
                i += 1;
             else i -=1;
        }
    }
}