class Solution {
    public int maximum69Number (int num) {
        int ans = num;
        ArrayList<Integer> list = new ArrayList<>();
        while(num > 0){
            list.add(num%10);
            num /= 10;
        }
        Collections.reverse(list);
        for(int i = 0; i < list.size(); i++){
            boolean f = false;
            if(list.get(i) == 6){
                list.set(i,9);
                f = true;
            }
            int nums = 0;
            for(int j: list) nums = (nums*10) + j;
            ans = Math.max(ans,nums);
            if(f) list.set(i,6);
        }
        return ans;
    }
}