class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int pre = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = shifts.length - 1; i >= 0; i--) {
            shifts[i] = ((shifts[i] % 26) + pre) % 26;
            pre = shifts[i];
        }

        char[] letters = s.toCharArray();
        int index = 0;
        for (char letter : letters) {
            // System.out.println((int) 'z');
            int rotation = letter + shifts[index++];

            char l = 'a';
            if ((rotation) <= 122) {
                l = (char) (rotation);
            } else {
                l = (char) (((rotation - 122) + 'a') - 1);
            }
            sb.append(l);
        }
        System.out.println("the rotation steps are :" + Arrays.toString(shifts));
        return sb.toString();
   
    }
}