class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int index1 = -1, index2 = -1, swap = 0, len = s1.length();
        if (s1.equals(s2))
           return true;
        StringBuilder sb = new StringBuilder(s2);
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                    swap += 1;

                if (swap == 1)
                        index1 = i;

                    else if (swap == 2) {
                            index2 = i;
                        sb.setCharAt(index1, s2.charAt(index2));
                        sb.setCharAt(index2, s2.charAt(index1));
                        // System.out.print(sb);
                        s2 = sb.toString();
                        if (s1.equals(s2))
                            return true;
                        else
                            return false;
                    }
            }
        }
        if (swap == 2){
           sb.setCharAt(index1, s2.charAt(index2));
           sb.setCharAt(index2, s2.charAt(index1));
           s2 = sb.toString();
           if(s1.equals(s2))
              return true;
            else 
            return false;
        }
        return false;
    }
}