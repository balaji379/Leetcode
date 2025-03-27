class Solution {
    public int minEatingSpeed(int[] piles, int h) {
         int min = 1,max = -1;
        for (int pile : piles){
            max = Math.max(pile,max);
        }
        int ans = max;
        while (min <= max){
            double no_of_b_eat = (max + min) / 2;
            int total_h = 0;
            for (int pile : piles){
                total_h += Math.ceil(pile / no_of_b_eat);
            }
            if (total_h <= h){
                ans = (int)Math.min(ans,no_of_b_eat);
                max = (int)(no_of_b_eat - 1);
            }
            else
                min =(int) (no_of_b_eat + 1);
        }
        return ans;
    }
}