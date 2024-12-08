class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        Set<String> set = new HashSet<>();
        generateParentheses(n, n - 1, n, "(", set, answer);
        return answer;
    }

     public static void generateParentheses(int n, int open, int close, String val, Set<String> set,
            List<String> answer) {
        if (open == 0 && close == 0) {
            if (!set.contains(val)) {
                answer.add(val);
                set.add(val);
                return;
            }
        }
        if (open == 1 && close == 1) {
            val += "()";
            if (!set.contains(val)) {
                answer.add(val);
                set.add(val);
            }
            return;
        }
        List<String> combination = new ArrayList<>();
        String tempstr = "";
        for (int i = 0; i < open; i++) {
            tempstr += "(";
            combination.add(tempstr);
        }
        tempstr = "";
        if (open != 0) {
            for (int i = 0; i < (close - open); i++) {
                tempstr += ")";
                combination.add(tempstr);
            }
        } else {
            tempstr = ")";
            tempstr = tempstr.repeat(close);
            combination.add(tempstr);
            // close = 0;
        }
        for (String str : combination) {

            if (open > 0 && str.charAt(0) == '(') {
                int newopen = Math.abs(open - str.length());
                String tempval = val + str;
                generateParentheses(n, newopen, close, tempval, set, answer);
            }

            else if (close > 0 && str.charAt(0) == ')') {

                int newclose = Math.abs(close - str.length());
                String tempval = val + str;
                generateParentheses(n, open, newclose, tempval, set, answer);

            }

        }
    }
}