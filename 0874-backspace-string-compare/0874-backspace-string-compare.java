class Solution {
    public static Stack<Integer> findValid(char[] letter) {
        Stack<Integer> valid_index = new Stack<>();
        for (int i = 0; i < letter.length; i++) {
            if (letter[i] == '#') {
                if (!valid_index.isEmpty())
                    valid_index.pop();
            } else
                valid_index.push(i);
        }
        return valid_index;
    }

    public boolean backspaceCompare(String a, String b) {
       char[] letter_a = a.toCharArray();
        char[] letter_b = b.toCharArray();
        Stack<Integer> valid_indexA = findValid(letter_a);
        Stack<Integer> valid_indexB = findValid(letter_b);
        if (valid_indexA.isEmpty() && valid_indexB.isEmpty())
            return true;
        else if (valid_indexA.isEmpty() || valid_indexB.isEmpty())
            return false;
        else if (valid_indexA.size() != valid_indexB.size())
            return false;
        else {
            while (!valid_indexA.isEmpty()) {
                if (letter_a[valid_indexA.pop()] != letter_b[valid_indexB.pop()])
                    return false;
            }
        }
        return true;
    }
}