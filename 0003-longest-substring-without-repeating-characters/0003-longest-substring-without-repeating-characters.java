class Solution {
    public int lengthOfLongestSubstring(String s) {
           HashMap<Character,Integer>hm=new HashMap<>();
        int len=s.length();
        int count=0,maxcount=0,start=0,end=0;
        while(end<len){
            while(hm.get(s.charAt(end))!=null){
                hm.remove(s.charAt(start));
                start++;
            }
          
            hm.put(s.charAt(end),end);
            count=end-start+1;
            maxcount=Math.max(count,maxcount);
            end++;
        }
        return maxcount;
    }
}