class Solution {
    public List<String> stringSequence(String target) {
         StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        int len = target.length();
        for (int i = 0; i < len; i++){
            char c = target.charAt(i);
            char start = 'a';
            while (start <= c && sb.length() <= i + 1){
                int size = sb.length();
                if (size == i + 1)
                    sb.setCharAt(size - 1,start);
                else
                    sb.append(start);
                list.add(sb.toString());
                start += 1;
                if (start > 'z' + 1)
                    start = 'a';

            }
        }
        return list;
    }
}