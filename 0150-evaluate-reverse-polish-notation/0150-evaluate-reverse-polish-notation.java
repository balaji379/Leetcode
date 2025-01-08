class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Set<String> operator = new HashSet<>();
        operator.addAll(List.of("+","*","-","/","%"));
        for (String token : tokens) {
            if (operator.contains(token)) {
                int operand1 = Integer.parseInt(stack.pop());
                int operand2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(performOperation(operand2,operand1,token.charAt(0))));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }
     public static int performOperation(int operand1 , int operand2,char operator){
        int ans = 0;
        switch (operator){
            case '+' :
                 ans = operand1 + operand2;
                 break;
            case '-' :
                 ans = operand1 - operand2;
                 break;
            case '*':
                ans = operand1 * operand2;
                break;
            case '/':
                ans = operand1 /operand2;
                break;
            case '%':
                ans = operand1 /operand2;
                break;
        }
        return ans;
    }
}