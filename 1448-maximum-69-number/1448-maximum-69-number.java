class Solution {
    public int maximum69Number (int num) {
         List<Integer> list = new ArrayList<>();
         while (num != 0) {
            list.add(0,num % 10);
            num /= 10;
         }
         int pow = list.size() - 1;
         num = 0;
         boolean flag = true;
        for (int val : list){
            if (val == 6 && flag){
                num += 9 * Math.pow(10,pow);
                flag = false;
            }
            else 
                num += val * Math.pow(10,pow);
            pow -= 1;
        }
        return num;
    }
}