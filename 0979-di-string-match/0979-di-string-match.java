class Solution {
    public int[] diStringMatch(String s) {
        char[] letters = s.toCharArray();
        int start =0 ,large = letters.length,index = 0;
        int[] answer = new int[letters.length+1];
        for(char letter : letters){
            if(letter == 'I')
              answer[index] = start++;
            else
             answer[index] = large--;
            index += 1;
        }
        if (letters[letters.length - 1] == 'I')
            answer[index] = start;
        else
            answer[index] = large;
        return answer;
    }
}