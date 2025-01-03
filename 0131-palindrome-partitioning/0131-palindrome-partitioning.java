class Solution {
    public List<List<String>> partition(String s) {
        
     List<String> list = new LinkedList<>();
        List<List<String>> answer = new ArrayList<>();
        generatePalindrome(list, answer, s, "", 0);
        return answer;
    }

    public static boolean checkPalindrome(String word) {
        if (word.length() == 1)
            return true;
        else {
            int start = 0, end = word.length() - 1;
            while (start <= end) {
                if (word.charAt(start++) != word.charAt(end--))
                    return false;
            }
        }
        return true;
    }

    private static void generatePalindrome(List<String> list, List<List<String>> answer, String word, String str, int index) {

        if (str.length() > 0) {
            if (!checkPalindrome(str))
                return;
        }
        if (index - word.length() == 0) {
            List<String> temp = new ArrayList<>();
            temp.addAll(list);
            answer.add(temp);
            return;
        }
        for (int i = index; i < word.length(); i++) {
            str = word.substring(index, i + 1);
            list.add(str);
            generatePalindrome(list, answer, word, str, index + str.length());
            list.removeLast();
        }
    }
}