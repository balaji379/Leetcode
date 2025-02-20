class Solution {
    private Set<String> set = new HashSet<>();
    public String findDifferentBinaryString(String[] nums) {
            for (String s : nums)
                 set.add(s);
            set.add("");
            return solve("",nums[0].length());
    }
    public String solve(String s ,int length){
         if (s.length() == length)
            if (!set.contains(s))
                return s;
            else return "";

        for (int i = 0; i < 2; i++){
            char c = (char)('0' + i);
            String ans = solve((s+String.valueOf(c)),length);
            if(!ans.equals(""))
                return ans;
        }
        return "";
    }
}