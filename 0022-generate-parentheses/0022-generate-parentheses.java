class Solution {
    HashSet<String> set = new HashSet<>();
    public List<String> generateParenthesis(int n) {
        solve(new StringBuilder("()"),1,n);
        ArrayList<String> ans = new ArrayList<>();
        for(String i: set) ans.add(i);
        return ans;
    }
    public void solve(StringBuilder sb,int c,int n){
        if(c == n){
            set.add(sb.toString());
            return;
        }

        for(int i = 0; i < sb.length(); i++){
            solve(sb.insert(i,"()"),c+1,n);
            sb.delete(i,i+2);
        }
    }
}