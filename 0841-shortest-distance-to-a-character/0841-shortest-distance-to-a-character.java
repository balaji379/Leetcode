class Solution {
    public int[] shortestToChar(String s, char c) {
        int len = s.length() ,  right = s.indexOf(c) , left = right;
        int[] answer = new int[len];
        for(int i = 0 ; i< len ; i++){
            answer[i] = Math.min(Math.abs(left-i),Math.abs(right-i)) ;
            if(i>right){
                left = right;
                right = s.indexOf(c,i);
                 if (right == -1)
                    right = Integer.MAX_VALUE;
                i--;
            }
        }
        return answer;
    }
}