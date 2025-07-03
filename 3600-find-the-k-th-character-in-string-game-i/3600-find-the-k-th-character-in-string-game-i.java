class Solution {
    public char kthCharacter(int k) {
            return solve("a",k,k);
    }
    public char solve(String s,int k,int pos){
        if(s.length() >= pos){
            return s.charAt(pos - 1);
        }
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < len; i++){
            char c = (char)((((s.charAt(i) + 1) - 'a') % 26) + 'a');
            sb.append(c);
        }
        System.out.println(sb.toString());
        return solve(sb.toString(),k - 1,pos);
    }
}