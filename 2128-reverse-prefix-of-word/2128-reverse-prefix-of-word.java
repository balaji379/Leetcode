class Solution {
    public String reversePrefix(String word, char ch) {
        int r = word.indexOf(ch),len = word.length();
        if (r == -1)
            return word;
        StringBuilder sb = new StringBuilder(word);
        int start = 0,end = r;
        while (start <= end){
            char temp = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start += 1;
            end -= 1;
        }
        return sb.toString();
    }
}