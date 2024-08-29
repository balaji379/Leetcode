class Solution {
    public String toGoatLatin(String sentence) {
         HashSet<Character> set = new HashSet<>(List.of('a','e','i','o','u','A','E','I','O','U'));
         String[] words = sentence.split(" ");
         String output = "",join_letter = "a";

         for(String word : words){
            if(set.contains(word.charAt(0))){
                   word+=("ma"+join_letter);
                   output +=(word+" ");
            }
            else{
                   char fl = word.charAt(0);
                   StringBuilder sb = new StringBuilder(word);
                   sb.deleteCharAt(0);
                   word = sb.toString();
                   word+= (String.valueOf(fl)+"ma")+join_letter;
                   output += (word+" ");
            }
            join_letter +="a";
         }
         return output.trim();
    }
}