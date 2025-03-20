class Solution {
    public int alternateDigitSum(int n) {
        String s=String.valueOf(n);
        int num=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(i%2==0){
                num+=(ch-'0');
            }
            else{
                num-=(ch-'0');
            }
        }
        return num;
    }
}