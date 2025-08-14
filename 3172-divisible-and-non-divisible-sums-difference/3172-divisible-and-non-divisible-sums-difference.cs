public class Solution {
    public int DifferenceOfSums(int n, int m) {
        int not = 0, yes = 0;
        for(int i = 1; i <= n; i++){
            if(i%m != 0) not+=i;
            else yes+=i;
        }
        return not - yes;
    }
}