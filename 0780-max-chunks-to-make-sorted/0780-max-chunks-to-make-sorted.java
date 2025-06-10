class Solution {
    public  int maxChunksToSorted(int...arr) {
        Stack<List<Integer>> stack = new Stack<>();
        for (int val : arr){
            if (stack.isEmpty()){
                List<Integer> list = new LinkedList<>();
                list.add(val);
                setHighValue(list);
                stack.push(list);
            }
            else if (stack.peek().get(0) < val){
                List<Integer> list = new LinkedList<>();
                list.add(val);
                stack.push(list);
            }
            else{
                List<Integer> temp = null;
                while (!stack.isEmpty() && stack.peek().get(0) > val){
                    if (temp == null){
                        temp = stack.pop();
                    }
                    else{
                        temp.addAll(stack.pop());
                    }
                }
                temp.add(val);
                stack.add(temp);
            }
        }
        return stack.size();
    }
    public  void setHighValue(List<Integer> list){
        int max = -1;
        int index = -1;
        for(int i = 0; i < list.size(); i++){
            int val = list.get(i);
            if (max < val){
                max = val;
                index = i;
            }
        }
        Collections.swap(list,0,index);
    }
}