class Solution {
    public int maxDifference(String s) {
            int[] letters = new int[27];
        int min = s.length(),max = Integer.MIN_VALUE;
        for (char c : s.toCharArray()){
            letters[c-'a'] += 1;
        }
        // System.out.print(Arrays.toString(letters));
        for (int count : letters){
            if (count % 2 != 0)
                 max = Math.max(max,count);
           if (count % 2 == 0 && count != 0)
                min = Math.min(min,count);
            }
        // System.out.print(max+" " +min);
        return max-min;
    }
}