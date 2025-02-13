class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int cost = 0;
        int c = 0,start = 0, end = 0,len = s.length(),index = 0,maxLength = 0;;
        if (maxCost == 0){
            if (s.equals(t))
              return s.length();
            else
              return 1;
        }
        while (end < len){
             cost  += Math.abs(s.charAt(end) - t.charAt(end));
             if (cost == maxCost){
                maxLength = Math.max(end - start + 1,maxLength);
                cost -= Math.abs(s.charAt(start) - t.charAt(start));
                start += 1;
             }
             else if (cost > maxCost){
                maxLength = Math.max(end - start,maxLength);
                while(cost > maxCost && start <= end){
                  cost -= Math.abs(s.charAt(start)-t.charAt(start));
                  start += 1;
                }
             }
             end += 1;
        }
        // System.out.println(maxLength +" start " + start + "end " + end) ;
        if(cost <= maxCost){
            System.out.println(cost);
            maxLength = Math.max(end - start,maxLength);
        }
        return maxLength;
    }
}