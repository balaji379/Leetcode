class Solution {
    public int[][] merge(int[][] intervals) {
       HashMap<Integer,int[]> map =new HashMap<>();
        int index = 0;
        for(int[] arr : intervals)
            map.put(index++,arr);
        List<Integer> key = new ArrayList<>();
       for(int k : map.keySet())
             key.add(k);
        key.sort((a,b)->{
             int first =map.get(a)[0];
             int second = map.get(b)[0];
             return first-second;
        });
        index=0;
        int len =key.size();
//        System.out.println("the key value is "+key+"the key 2 index :"+Arrays.toString(map.get(key.get(2))));
        for(int i =0 ;i<len-1 ;i++){
            int[] arr1= map.get(key.get(i));
            int[] arr2= map.get(key.get(i+1));
            if(arr1[1]>=arr2[0]){
                int startTime = arr1[0];
                arr2[0] = startTime;
                if(arr1[1]>arr2[1]) {
                     arr2[1]=arr1[1];
                }
                map.remove(key.get(i));
            }
        }
        int[][] ans =new int[map.size()][2];
        int i =0;
        for(int[] v : map.values()){
            for(int value : v){
                ans[index][i++]=value;
            }
            index+=1;
            i=0;
        }
        return ans;
    }
}