class Solution {
    public int[] smallerNumbersThanCurrent(int[] arr) {
        int[]array= new int[arr.length];
            int count =0;
            for(int i=0;i<arr.length;i++){
                for(int j=arr.length-1;j>=0;j--){
                    if(i != j && arr[j] < arr[i]){
                        count++;
                    }

                }
                array[i]=count;
                count=0;

            }
       return array;
    }
}