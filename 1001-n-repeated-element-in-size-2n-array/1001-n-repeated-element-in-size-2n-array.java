class Solution {
    public int repeatedNTimes(int[] nums) {
           HashMap<Integer,Integer> map = new HashMap<>();
           for(int val : nums){
            if(map.containsKey(val)) 
                map.replace(val,map.get(val)+1);
            else map.put(val,1);
           }
           int max = Integer.MIN_VALUE;
           int output = 0;
           for(Map.Entry<Integer,Integer> box :map.entrySet()){
                        if(box.getValue()>=max){
                            output =box.getKey();
                            max = box.getValue();
                        }
           }
           return output;
    }
}