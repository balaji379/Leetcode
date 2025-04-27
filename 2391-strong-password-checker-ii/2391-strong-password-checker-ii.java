class Solution {
    public boolean strongPasswordCheckerII(String password) {
        boolean lower = false,upper = false,digit = false,spcial = false;
        Set<Character> validChar = Set.of('!','@','$','#','%','^','&','*','(',')','-','+');
        char pre = '/';
        for (char c : password.toCharArray()){
            if (pre == c)
               return false;
            if (Character.isDigit(c))
                digit = true;
            else if (Character.isLowerCase(c))
                lower = true;
            else if (Character.isUpperCase(c))
                upper = true;
            else if (validChar.contains(c))
               spcial = true;
            pre =c;
        }
        boolean ans = (upper && spcial && lower && digit && password.length() >= 8);
        return ans;
    }
}