class Solution {
    public long minimumSteps(String s) {
         long swapCount = 0;
         long count_one = 0;
         for( char letter : s.toCharArray()){
             if( letter == '1')
                count_one += 1;
             if( count_one != 0 && letter == '0')
                    swapCount += (count_one * 1);
                      }
         return swapCount;
    }
}