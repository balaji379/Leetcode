class Solution {
    public int longestMountain(int[] arr) {
         int max = 0;
         for (int i = 0; i < arr.length; i++){
            if (i > 0 && i < arr.length - 1){
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]){
                    int len = getLengthOfMount(i,arr);
                    max = Math.max(len,max);
                }
            }
         }
         return max;
    }
         private static int getLengthOfMount(int peekIndex,int...arr){
              int start = peekIndex,end = peekIndex;
              int max = 0;
              boolean flag = true;
             while (flag && (start > 0 || end < arr.length -1)){
                if (start > 0 && arr[start] > arr[start -1]){
                      start -= 1;
                      flag = true;
                }
                else flag = false;
                if (end < arr.length - 1 && arr[end] > arr[end + 1]){
                       end += 1;
                       flag = true;
             }
                else {
                    if (flag == false)
                       break;
                    else flag = true;
                }
             }
             return Math.max(max,((end - start)+1));
       }

}