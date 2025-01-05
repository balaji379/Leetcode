class Solution {
    public boolean lemonadeChange(int[] bills){
       return lemonadeChanges(bills);
    }
    public boolean lemonadeChanges(int...bills) {
        int five = 0, ten = 0, t = 0;
        for (int bill : bills) {
            int change = bill - 5;
            if (change == 0)
                five += 1;
            else {
                if (change >= 20) {
                    while (change >= 20 && t > 0) {
                        change -= 20;
                        t -= 1;
                    }
                }
                if (change >= 10) {
                    while (change >= 10 && ten > 0) {
                        change -= 10;
                        ten -= 1;
                    }
                }
                if (change >= 5) {
                    while (change >= 5 && five > 0) {
                        change -= 5;
                        five -= 1;
                    }
                }
                if (change == 0) {
                    if (bill == 5)
                        five += 1;
                    else if (bill == 10)
                        ten += 1;
                    else
                        t += 1;
                } else return false;
            }
        }
        return true;
    }
}