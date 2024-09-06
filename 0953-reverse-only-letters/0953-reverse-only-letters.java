class Solution {
    public String reverseOnlyLetters(String str) {
        int start = 0, end = str.length();
        char[] characters = new char[end];
        for (var c : str.toCharArray())
            characters[start++] = c;
        start = 0;
        end -= 1;
        while (start <= end) {
            if (Character.isLetter(characters[start]) && Character.isLetter(characters[end])) {
                char temp = characters[start];
                characters[start] = characters[end];
                characters[end] = temp;
                start += 1;
                end -= 1;
                continue;
            } else {
                if (!Character.isLetter(characters[start]))
                    start += 1;
                else
                    end -= 1;
            }
        }
        // System.out.println("the final output is :" + Arrays.toString(characters));
        StringBuilder sb = new StringBuilder();
        for (char c : characters) {
            sb.append(c);
        }
        return sb.toString();
    }
}