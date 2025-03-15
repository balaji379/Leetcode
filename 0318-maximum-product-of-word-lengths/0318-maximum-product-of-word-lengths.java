class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            Set<Character> set = new HashSet<>();
            for (char c : words[i].toCharArray())
                set.add(c);
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].length() * words[j].length() > max) {
                    boolean flag = true;
                    for (char c : words[j].toCharArray()) {
                        if (set.contains(c)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag)
                        max = words[i].length() * words[j].length();
                }
            }
        }
        return max;
    }
}