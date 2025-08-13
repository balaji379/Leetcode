public class Solution {
    public int ScoreOfString(string s) {
        int ans = 0;
        for(int i = 0; i < s.Length-1; i++){
            ans += Math.Abs((s[i] - 'a') - (s[i+1] - 'a'));
        }
        return ans;
    }
}