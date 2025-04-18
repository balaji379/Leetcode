class Solution {
    public String stringHash(String s, int k) {
        int len = s.length();
          StringBuilder res = new StringBuilder();
          for (int i = 0; i < len;){
            int sum = 0;
            int start = 0;
            StringBuilder sb = new StringBuilder();
            while (i < len && start < k){
               sum += (s.charAt(i) - 'a');
               i += 1;
               start += 1;
            }
            // System.out.println(sum);
            int pos = sum % 26;
            res.append((char)(pos + 'a'));
          }
          return res.toString();
    }
}