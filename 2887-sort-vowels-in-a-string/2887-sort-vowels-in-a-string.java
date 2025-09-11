class Solution {
    public String sortVowels(String s) {
        int n = s.length();
        ArrayList<Character> vowels = new ArrayList<>();
        char[] t = new char[n];
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c != 'a' && c != 'A' && c != 'e' && c != 'E' && c != 'i' && c != 'I' && c != 'o' && c != 'O' && c != 'u' && c != 'U') t[i] = c;
            else vowels.add(c);
        }
        Collections.sort(vowels);
        for(int i = 0; i < n; i++){
            if(!((t[i] >= 'A' && t[i] <= 'Z' )|| (t[i] >= 'a' && t[i] <= 'z'))){
                t[i] = vowels.remove(0);
            }
        }
        return new String(t);
    }
}