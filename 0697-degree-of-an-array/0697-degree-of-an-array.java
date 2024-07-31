class Solution {
    public int findShortestSubArray(int[] nums) {

             HashMap<Integer ,int[]> map = new HashMap<>();
             int i = 0;
             for(int v : nums){
                if(map.containsKey(v)){
                       map.get(v)[0]++;
                       map.get(v)[2]=i;
                }
                else{
                    map.put(v,new int[3]);
                    map.get(v)[0]++;
                    map.get(v)[1]=i;
                }
                i++;
             } 

            int max =Integer.MIN_VALUE;
            for(int[] arr :map.values() ){
                if(arr[0]>max)
                   max = arr[0];          
            }
            int min = Integer.MAX_VALUE;
            for(int[] arr : map.values()){
                if(arr[2]>0 && arr[0]==max){
                    min = Math.min(min,(arr[2]-arr[1]));
                }
            }
        
            return min==Integer.MAX_VALUE?1:min+1;
    }
}