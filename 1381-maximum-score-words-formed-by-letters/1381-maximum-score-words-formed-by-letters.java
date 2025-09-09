class Solution {
    HashMap<Character,Integer> map = new HashMap<>();
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        for(char c: letters) map.put(c,map.getOrDefault(c,0) + 1);
        int ans = solve(0,words,score);
        return ans;
    }

    public int solve(int idx,String[] words,int[] score){
        if(idx == words.length) return 0;

        int without = solve(idx+1,words,score);
        HashMap<Character,Integer> temp = new HashMap<>();
        for(char c: words[idx].toCharArray()) temp.put(c,temp.getOrDefault(c,0) + 1);
        int with = 0;
        boolean same = true;
        for(char c: words[idx].toCharArray()){
            if(map.getOrDefault(c,0) < temp.get(c)){
                same = false;
                break;
            }
        }
        if(same){
            int currentScore = 0;
            for(char c: temp.keySet()){
                map.put(c,map.get(c) - temp.get(c));
                currentScore += score[c - 'a'] * temp.get(c);
            }
            with = currentScore + solve(idx+1,words,score);
            for(char c : temp.keySet()){
                map.put(c,map.get(c) + temp.get(c));
            }
        }
        return Math.max(without,with);
    }
}