public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int value) {
        int reverse = 0;
           for (int i = 1; i <= 32; i++) {
            reverse = reverse | (value & 1);
            if (i <= 31)
                reverse = reverse << 1;
            value = value >> 1;
        }
        return reverse;
    }
}