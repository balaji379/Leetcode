class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if(words.length > s.length()) return ans;
        int w = words[0].length();
        int total = w*words.length;
        ArrayList<String> list = new ArrayList<>();
        for(String i: words) list.add(i);
        Collections.sort(list);
        for(int i = 0; i <= s.length() - total; i++){
            ArrayList<String> temp = new ArrayList<>();
            for(int j = i; j < i+total; j+=w){
                String sub = s.substring(j,j+w);
                temp.add(sub);
            }
            Collections.sort(temp);
            if(list.equals(temp)) ans.add(i);
        }
        return ans;
    }
}