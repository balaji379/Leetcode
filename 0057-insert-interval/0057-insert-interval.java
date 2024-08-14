class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
     HashMap<Integer,int[]> schedule = new HashMap<>();
     List<Integer> key = new LinkedList<>();
     schedule.put(newInterval[0],newInterval);
     key.add(newInterval[0]);
     for(int[] show : intervals){
        if(schedule.containsKey(Integer.valueOf(show[0]))){
          schedule.get(show[0])[1] = 
               show[1]>=schedule.get(show[0])[1]?show[1]:schedule.get(show[0])[1];
        }
        else{
            schedule.put(show[0],show);
            key.add(show[0]);
        }
     }
     key.sort((a,b)->{
         if(schedule.get(a)[0]==schedule.get(b)[0]){
            return schedule.get(a)[1] - schedule.get(b)[1];
         }
         else return schedule.get(a)[0]-schedule.get(b)[0];
     });
     for(int i =0 ;i<key.size()-1;i++){
        int[] first = schedule.get(key.get(i));
        int[] second = schedule.get(key.get(i+1));
        if(first[1]>=second[0]){
            schedule.get(key.get(i))[1] = Math.max(first[1],second[1]);
            key.remove(i+1);
            i--;
        }
     }
     int[][] output = new int[key.size()][2];
     int index =0 ;
     for(int k:key)
           output[index++] = schedule.get(k);
     return output;
    }
}