class Solution {
    public int[] numberOfLines(int[] widths, String s) {
             int  line = 0 , pixel = 0;
             char carr[] = s.toCharArray();
             for (int i = 0; i<carr.length ;i++){
                     pixel += widths[carr[i]-'a'];   
                     if(pixel>100) 
                         {
                            line+=1;
                            i--;
                            pixel=0;
                         }
             }
             int[] ans ={pixel<=100?line+1:line,pixel};
             return ans ;
    }
}