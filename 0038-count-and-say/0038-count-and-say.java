class Solution {
    public String countAndSay(int n) {
         List<List<Integer>> list = new LinkedList<>();
        list.add(List.of(1));
        int index = 0, itr = 1;
        while (itr < n) {
            int pre = list.get(index).get(0), val = pre, count = 0;
            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < list.get(index).size(); i++) {
                if (pre == list.get(index).get(i)) {
                    count += 1;
                } else {
                    temp.add(count);
                    temp.add(val);
                    pre = list.get(index).get(i);
                    val = pre;
                    i -= 1;
                    count = 0;
                }
            }
            if (count != 0) {
                temp.add(count);
                temp.add(val);
            }
            list.add(temp);
            index += 1;
            itr += 1;

        }
        return list.get(index).toString().replaceAll("\\[|\\]|, ", "");
       
    
    }
}