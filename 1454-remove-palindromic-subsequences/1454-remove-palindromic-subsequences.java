class Solution {
    public int removePalindromeSub(String s) {
        int start = 0 , end = s.length() - 1;
        boolean flag = true;
        while (start <= end){
            if (s.charAt(start) != s.charAt(end)){
                flag = false;
                break;
            }
            start += 1;
            end -= 1;
        }
        if (!flag)
           return 2;
        else return 1;
    }
}