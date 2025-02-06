class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*'){
                String a = expression.substring(0,i);
                String b = expression.substring(i + 1);
                List<Integer> left = diffWaysToCompute(a);
                List<Integer> right = diffWaysToCompute(b);
                for (int v : left){
                    for (int v2 : right){
                        if (c == '+')
                           res.add(v + v2);
                        else if (c == '*')
                           res.add(v * v2);
                        else if (c == '-')
                           res.add(v - v2);
                    }
                }
            }
        }
        if (res.size() == 0)
            res.add(Integer.parseInt(expression));
         return res;
    }
}