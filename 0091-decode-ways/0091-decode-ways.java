class Solution {
    public int numDecodings(String s) {
        
        char[] letters = s.toCharArray();
        int[] dp = new int[letters.length + 1];
        Arrays.fill(dp, 0);
        return countpossibleWaytoDecode(letters, dp, 0, 0);
    }

    public int countpossibleWaytoDecode(char[] letters, int[] dp, int index, int count) {

        if (index >= letters.length)
            return 1;

        if (dp[index] != 0)
            return dp[index];

        if (letters[index] == '0')
            return 0;

        int c = countpossibleWaytoDecode(letters, dp, index + 1, count);

        int val = (int) (letters[index] - '0') * 10;
        if (index < letters.length - 1) {
            val = val + (int) (letters[index + 1] - '0');
            if (val >= 27) {
                dp[index] = c;
                return c;
            } else {
                int c1 = countpossibleWaytoDecode(letters, dp, index + 2, count);
                dp[index] = c + c1;
            }
        }else dp[index] = c;
        return dp[index];
    }

}