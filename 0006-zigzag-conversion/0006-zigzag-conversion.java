class Solution {
    public String convert(String s, int rows) {
        StringBuilder ans = new StringBuilder();
        List<List<Character>> list = new ArrayList<>();
        for(int i = 0; i < rows; i++) list.add(new ArrayList<>());
        int idx = 0;
        while(idx < s.length()){
            boolean flag = false;
            for(int i = 0; i < rows; i++){
                if(idx >= s.length()){
                    flag = true;
                    break;
                }
                list.get(i).add(s.charAt(idx++));
            }
            if(flag) break;
            for(int i = rows - 2; i > 0; i--){
                if(idx >= s.length()){
                    flag = true;
                    break;
                }
                list.get(i).add(s.charAt(idx++));
            }
            if(flag) break;
        }
        for(List<Character> i: list){
            for(char c: i) ans.append(c);
        }
        return ans.toString();
    }
}