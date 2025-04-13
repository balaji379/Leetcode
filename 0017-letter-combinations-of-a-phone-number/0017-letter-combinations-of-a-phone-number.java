class Solution {
    ArrayList<String> list = new ArrayList<>();
    Map<Character,String> map = Map.of('2',"abc",'3',"def",'4',"ghi",'5',"jkl",'6',"mno",'7',"pqrs",'8',"tuv",'9',"wxyz");

    public List<String> letterCombinations(String digits) {
        
        solve("",digits,0);
      
        return list;
    }
    public void solve(String p,String d,int index){
        if (index >= d.length()){
            if (!p.isEmpty())
              list.add(p);
             return;
        }
        String s = map.get(d.charAt(index));
        int len = s.length();
        for (int i = 0; i < len; i++){
            solve(p + String.valueOf(s.charAt(i)),d,index + 1);
        }
    }
}