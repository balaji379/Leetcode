class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer , Integer > map = new HashMap<>();
        var i = 0;
        for( int num : arr)
           map.put(num , i++);
        for( i = 0; i < arr.length; i++){
            if( map.containsKey(arr[i]*2) && map.get(arr[i]*2) != i)
               return true;
        }
        return false;
    }
}