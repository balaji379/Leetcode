class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
         for (int i = low; i <= high; i++){
              if (isSymmetricIntegers(i))
                   count += 1;
         }
         return count;
    }
    public boolean isSymmetricIntegers(int num){
        String s = String.valueOf(num);
        int mid = s.length(),len = s.length();
        mid /= 2;
        if (len % 2  != 0 || len == 1)
           return false;
        else {
            int left = mid - 1,right = mid;
            int leftsum = 0 , rightsum = 0;
            while (left >= 0 && right < len){
                    leftsum += s.charAt(left) - '0';
                    rightsum += s.charAt(right) - '0';
                    left -= 1;
                    right += 1;
            }
            if(leftsum == rightsum)
                 return true;
            else return false;
           
        }
    }
}