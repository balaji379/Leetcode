class Solution {
    public int maxNumberOfBalloons(String text) {
       
        int[] freq = new int[5];
        
       
        for (char c : text.toCharArray()) {
            switch (c) {
                case 'b':
                    freq[0]++;
                    break;
                case 'a':
                    freq[1]++;
                    break;
                case 'l':
                    freq[2]++;
                    break;
                case 'o':
                    freq[3]++;
                    break;
                case 'n':
                    freq[4]++;
                    break;
            }
        }
        
      
        freq[2] /= 2;
        freq[3] /= 2;
        
       
        int minFreq = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            minFreq = Math.min(minFreq, freq[i]);
        }
        
        return minFreq;
    }
}