class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
    //    Set<String> checker = new HashSet<>();
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        Set<String> checker = new HashSet<>();
        wordDict.stream().forEach(a->checker.add(a));
        // System.out.println("the answer is : " + findSegment(s, checker, 0, dp));
        // System.out.println(Arrays.toString(dp));
        return findSegment(s,checker,0,dp);

    }

    public static boolean findSegment(String str, Set<String> set, int pos, int[] dp) {
        if (str.length() == 0)
            return true;
        if (dp[pos] != -1)
            return (dp[pos] == 0 ? false : true);

        int len = str.length();
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            String s = str.substring(0, i + 1);
            if (set.contains(s)) {
                flag = findSegment(str.substring(i + 1), set, pos + i + 1, dp);
                if (flag) {
                    dp[pos] = 1;
                    return flag;
                }
            }
        }
        dp[pos] = 0;
        return flag;
    }
}
