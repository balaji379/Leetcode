class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        int count=0;
        boolean flage=false;
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int ans : map.values()){
            count+=(ans/2)*2;
            if(ans%2==1){
                flage=true;
            }
        }
        if(flage){
            count+=1;
        }
        return count;
    }
}