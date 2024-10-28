class Solution {
    public int reverse(int i) {
        boolean sign=true;
        if(i<0){
            sign=false;
        }
        long rev=0;
        i=Math.abs(i);
        while(i>0){
        rev=rev*10+(i%10);
        if(rev>Integer.MAX_VALUE||rev<Integer.MIN_VALUE){
            return 0;
        }
        i=i/10;
        }
        if(sign==false)
        rev=-1*rev;
        return (int)rev;
    }
}
