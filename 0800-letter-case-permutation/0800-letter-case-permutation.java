class Solution {
    Set<String> set = new HashSet<>();
    List<String> list = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        solve(s, new StringBuilder(s), 0, s.length());
        return list;
    }

    public void solve(String s, StringBuilder sb, int index, int len) {
        if (!set.contains(s)) {
            list.add(s);
            set.add(s);
        }
        if (index >= len) {
            if (!set.contains(s)) {
                list.add(s);
                set.add(s);
            }
            return;
        }

        for (int i = index; i < len; i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                char t = '-';
                if (c >= 'a' && c <= 'z')
                   t = Character.toUpperCase(c);
                else
                   t = Character.toLowerCase(c);
                sb.setCharAt(i, t);
                solve(sb.toString(), sb, i + 1, len);
                sb.setCharAt(i, c);
                solve(sb.toString(), sb, i + 1, len);
            }
        }
    }

}