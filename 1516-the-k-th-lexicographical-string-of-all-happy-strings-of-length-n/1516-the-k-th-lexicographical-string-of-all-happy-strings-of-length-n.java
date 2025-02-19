class Solution {
    public String getHappyString(int n, int k) {
       List<String> list = new ArrayList<>();
       findKelement(list, "", n, 'd', k);
       return   list.size() >= k ? list.get(k-1) : "";
    }

    public static void findKelement(List<String> list, String s, int n, char pre, int k) {
        if (s.length() == n) {
            list.add(s);
            return;
        }

        for (int i = 0; i < 3; i++) {
            char cha = (char) (i + 'a');
            if (cha != pre) {
                 findKelement(list, s + String.valueOf(cha), n, cha, 4);
            }
        }
    }
}
