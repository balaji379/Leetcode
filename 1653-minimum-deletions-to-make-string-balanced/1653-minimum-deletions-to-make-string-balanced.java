class Solution {
    public int minimumDeletions(String s) {
          char[] carr =s.toCharArray();
           int prefix =0 ,total =0 ;
           int len = carr.length,i =0 ;
           while(i<len){
               if(carr[i]=='b') prefix +=1;
               if(prefix>0 && carr[i]=='a'){
                    prefix-=1;
                    total+=1;
                   }
                   i+=1;
           }
           return total;
    }
    }