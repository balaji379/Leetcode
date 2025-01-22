class Solution {
    public long smallestNumber(long nums) {
        if (nums == 0 )
           return nums;
        List<Integer> list = new LinkedList<>();
        long temp = Math.abs(nums);

        while (temp != 0) {
            list.add((int)(temp % 10));
            temp /= 10;
        }
        if (nums < 0)
            Collections.sort(list, (a, b) -> b - a);
        else
            Collections.sort(list);
        if (list.get(0) == 0) {
            boolean flag = true;
            for (int i = 1; i < list.size() - 1; i++) {
                 if (list.get(i) != 0){
                     int f = list.getFirst();
                     list.set(0,list.get(i));
                     list.set(i,f);
                     flag = false;
                     break;
                 }
            }
            if (flag) {
                int f =  list.getFirst();
                list.set(0,list.getLast());
                list.set(list.size() - 1,f);
            }
        }
        long newnum = 0;
        long pow = 10;
        for (int i = 0; !list.isEmpty(); i++){
            long n = list.removeLast();
            newnum += (n*Math.pow(pow,i));
        }
        if (nums < 0)
             newnum *= -1;
        return newnum;
    }
}