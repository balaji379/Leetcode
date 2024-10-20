import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
 List<Integer> result = new ArrayList<>();
        int carry = 0;
        int n = num.length;

        
        for (int i = n - 1; i >= 0 || k > 0; i--) {
            int digit = (i >= 0) ? num[i] : 0; 
            int sum = digit + (k % 10) + carry; 
            result.add(sum % 10); 
            carry = sum / 10; 
            k /= 10; 
        }

      
        if (carry > 0) {
            result.add(carry);
        }

      
        List<Integer> finalResult = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            finalResult.add(result.get(i));
        }

        return finalResult;
    }
}
