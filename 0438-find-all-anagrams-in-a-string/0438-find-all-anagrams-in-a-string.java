class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] checkercount = new int[27];
        char letter[] = p.toCharArray();
        List<Integer> list = new ArrayList<>();
        if (p.length() > s.length())
           return list;
        for (char c : letter)
            checkercount[c - 'a'] += 1;
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (start < p.length()) {
            sb.append(s.charAt(start++));
        }
        int len = s.length();
        for (int i = start, index = 0; i <= len; i++, index++) {
            int[] count = new int[26];
            for (char c : sb.toString().toCharArray())
                count[c - 'a'] += 1;
            boolean flag = true;
            for (char c : letter) {
                if (count[c - 'a'] != checkercount[c - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                list.add(index);
            if (i < len) {
                sb.deleteCharAt(0);
                sb.append(s.charAt(i));
            }
        }
        // System.out.print(list + " " + sb);
        return list;
    }
}