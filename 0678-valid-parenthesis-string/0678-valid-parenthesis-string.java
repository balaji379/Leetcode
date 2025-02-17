class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low--;
                high--;
            } else { // c == '*'
                low--; // Treat '*' as ')'
                high++; // Treat '*' as '('
            }
            
            // low should not go below 0
            if (low < 0) {
                low = 0;
            }
            
            // If high is negative, we have more ')' than we can match
            if (high < 0) {
                return false;
            }
        }
        
        // At the end, low should be 0 for a valid string
        return low == 0;
    }
}