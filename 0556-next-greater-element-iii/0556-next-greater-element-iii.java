class Solution {
   public int nextGreaterElement(int n) {
        String s =  String.valueOf(n);
        char[] digits = s.toCharArray();
        TreeSet<Integer> q = new TreeSet<>((a, b)->digits[a]-digits[b]);
        boolean flag = false;
        for (int i = digits.length - 1; i >= 0; i--){
            if (q.isEmpty())
                q.add(i);
            else{
                if (q.higher(i) != null && digits[q.higher(i)] > digits[i]){
                    int index = q.higher(i);
                    char temp = digits[i];
                    digits[i] = digits[index];
                    digits[index] = temp;
                    Arrays.sort(digits,i + 1,digits.length);
                    flag = true;
                    break;
                }
                q.add(i);
            }
        }
        if (!flag)
            return -1;
        else{
            s = new String(digits);
            long val = Long.parseLong(s);
            if (val <= Integer.MAX_VALUE)
                return (int)val;
        }
        return -1;
    }
}