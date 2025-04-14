class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
         for (int i = 0; i < arr.length; i++){
            int x = arr[i];
            for (int j = i + 1; j < arr.length; j++){
                int y = arr[j];
                for (int k = j + 1; k < arr.length; k++){
                    int z = arr[k];
                    if (Math.abs(x-y) <= a && Math.abs(y-z) <= b && Math.abs(x-z) <= c)
                       count += 1;
                }
            }
         }
         return count;
    }
}