class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()<=k) return "0";
       int tempk = k;
        Stack<Character> stack = new Stack<>();
        String output = "";
        char[] nums = num.toCharArray();
        for (char no : nums) {
            if (stack.isEmpty())
                stack.push(no);
            else {
                while (!stack.isEmpty() && k >= 1 && stack.peek() > no) {
                    stack.pop();
                    k -= 1;
                }
                stack.push(no);
            }

        }
         if (k != 0) {
            while (k != 0) {
                stack.pop();
                k -= 1;
            }
        }
        while (!stack.isEmpty())
            output = stack.pop()+output;
          String answer = output.replaceFirst("^0+", "");
          if(answer.equals("")) return "0";
          else return answer;
       
    }
}