class Solution {
    public int maximumGroups(int[] grades) {
        //   Arrays.sort(grades);
          int count = 0;
          int len = grades.length;
          for (int i = 1; true; i++){
              if (len - i >= 0) 
                 count += 1;
              else 
                 break;
              len -= i;
          }
          return count;
    }
}