class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
          int start = 0, end = 2 ,count = 0;
        while (start < colors.length){
            int mid = start + 1;
            if (mid >= colors.length)
                 mid = 0;
            if (colors[start] != colors[mid] && colors[mid] != colors[end == colors.length ? 0 : end]){
                count += 1;
            }
            else if (end == colors.length )
                break;
            end += 1;
            start += 1;
            if (end >= colors.length)
                 end = 0;
        }
        return count;
    }
}
