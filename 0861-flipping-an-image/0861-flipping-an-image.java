class Solution {
    public void reverse ( int[][] arr){
        for(int i = 0; i < arr.length; i++){
            int start = 0,end = arr[i].length - 1;
            while( start <= end){
                int temp = arr[i][start];
                arr[i][start] = arr[i][end];
                arr[i][end] = temp;
                start += 1;
                end -= 1;
            }
        }
    }
    public int[][] flipAndInvertImage(int[][] image) {
         reverse(image);
         inverse(image);
         return image;
    }
    public void inverse( int[][] arr){
        for( int i = 0; i < arr.length; i++){
            for( int j = 0; j < arr[i].length; j++){
                if(arr[i][j] == 0)
                   arr[i][j] = 1;
                else 
                  arr[i][j] = 0;
            }
        }
    }
}