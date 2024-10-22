class Solution {
    public int heightChecker(int[] heights) {
    int[] h = new int[heights.length];
    int index = 0, mismatchcount = 0;
    while (index < h.length) {
        h[index] = heights[index];
        index += 1;
    }
    Arrays.sort(heights);
    for (int i = 0; i < h.length; i++) {
        if (heights[i] != h[i])
          mismatchcount += 1;
    }
   return mismatchcount;
    }
}