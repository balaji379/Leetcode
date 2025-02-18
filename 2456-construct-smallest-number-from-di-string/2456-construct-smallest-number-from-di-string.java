class Solution {
    public String smallestNumber(String pattern) {
        return formNum(pattern);
    }
    public  String formNum(String s){
        Stack<String> stack = new Stack<>();
        int len = s.length(),val = 1;
        StringBuilder sb =new StringBuilder();
        int i = 0;
        while (i < len){
            if (s.charAt(i) == 'I')
                 sb.append(val++);
            else if (s.charAt(i) == 'D'){
                while(i < len && s.charAt(i) == 'D'){
                    stack.push(String.valueOf(val++));
                    i += 1;
                }
                    stack.push(String.valueOf(val++));
                while(!stack.isEmpty())
                     sb.append(stack.pop());
            }
            i += 1;
        }
        if (s.charAt(len - 1) == 'I')
              sb.append(val);
        return sb.toString();
    }
}