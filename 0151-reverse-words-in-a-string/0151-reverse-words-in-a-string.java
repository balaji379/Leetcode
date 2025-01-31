class Solution {
    public String reverseWords(String s) {
     
        String[] words = s.split(" ");
        int i = 0 , j = words.length - 1;
        while (i <= j){
            String temp = words[i];
            words[i++] = words[j];
            words[j--] = temp;
        }
        s ="";
        for (String val : words){
            if(!val.replace(" ","").equals(""))
                s = s +" "+ val;
        }
        return s.trim();
    }
    
}