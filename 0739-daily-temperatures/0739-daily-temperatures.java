class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
         Stack<Integer> warmerDays = new Stack<>();
         int[] answer = new int[temperatures.length];
         int index = temperatures.length-1;
         for(int i = temperatures.length-1; i>=0; i-- ){
            if(warmerDays.isEmpty()){
                    answer[index] = 0;
                    warmerDays.push(i);
            }
            else{
                  while(!warmerDays.isEmpty() && temperatures[warmerDays.peek()] <= temperatures[i]){
                      warmerDays.pop();
                  }
                  if(warmerDays.isEmpty()){
                    answer[index] = 0;
                  }
                  else{
                    answer[index] = Math.abs(warmerDays.peek()-i);
                  }
                  warmerDays.push(i);
            }
            index -= 1;
         }
         return answer;
    }
}