class Solution {
    public String longestCommonPrefix(String[] str) {
            if(str.length==1){
            return str[0];
        }
        int count=0,max=0,bcount=0;
        String firstString=str[0];
        LinkedList<String> ls=new LinkedList<>();
        for(String s:str){
            ls.add(s);
            if(firstString.length()>s.length()){
            max=count;}
            count++;
        }
        String check,output="",p="",s=ls.remove(max);
        boolean b=false;
        inner:
        for(int i=0;i<s.length();i++){
            p=String.valueOf(s.charAt(i));
            for(int j=0;j<ls.size();j++){
              check=ls.get(j);
              b=check.startsWith(p,i);
              if(b==true)
              bcount++;
              
              else
              break inner;
            }
              if(bcount==ls.size()){
                  output=output+p;
                  bcount=0;
              }
        }
         
        return output;
    }
}