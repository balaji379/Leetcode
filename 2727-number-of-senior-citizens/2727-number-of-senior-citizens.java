class Solution {
    public int countSeniors(String[] details) {
           int count = 0;
           for(String s : details){
                int age = 0,pow = 0;
               char[] carr = s.toCharArray();
                age += carr[12]-48;
                age+=(carr[11]-48)*10;
                if(age > 60 ){
                  count+=1;
                   
                } 
           } 
        return count;
    }
}