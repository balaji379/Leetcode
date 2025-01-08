class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count  = 0;
        for (int i = 0; i < words.length; i++){
           for (int j = i + 1; j < words.length; j++){
            if (isPrefixAndSuffix(words[i],words[j]))
                 count += 1;
           }
        }
        return count;
    }

    public static boolean isPrefixAndSuffix (String a , String b){
        if (b.startsWith(a) && a.length() < b.length()){
            int start = b.length() - a.length();
            String temp = b.substring(start);
            return temp.equals(a);
        }
        return false;
    }

}