class Solution {
    Map<String, Boolean> map = new HashMap<>();
    public boolean isInterleave(String s1, String s2, String s3) {
        if (!(s3.length() == (s1.length() + s2.length())))
                  return false;
        return solve(s1,s2,s3,0,0,0);
    }

public boolean solve(String s1, String s2, String s3, int index1, int index2, int index3) {
        if (index3 >= s3.length())
            return true;
        String key = String.valueOf(index1) + "*" + String.valueOf(index2) + "*" + String.valueOf(index3);
        if (map.containsKey(key))
              return map.get(key);
        boolean flag1 = false, flag2 = false;
        if (index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3)) {
            flag1 = solve(s1, s2, s3, index1 + 1, index2, index3 + 1);
        }

        if (index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3)) {
            flag2 = solve(s1, s2, s3, index1, index2 + 1, index3 + 1);
        }
        map.put(key, (flag2 || flag1));


        return map.get(key);
    }
}