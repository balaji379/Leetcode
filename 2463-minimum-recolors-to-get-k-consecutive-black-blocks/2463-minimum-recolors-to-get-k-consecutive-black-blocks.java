import java.util.Collection;
class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        char[] carr=blocks.toCharArray();
        int i=0,j=0,len=carr.length;
        HashMap<Integer,Integer> countw=new HashMap<>();
        while(j<len){
            if(carr[j]=='W'){
                if(countw.containsKey(i)){
                    countw.replace(i,countw.get(i)+1);
                }
                else countw.put(i,1);}
            else if(k==1) return 0;
                if((j-i)+1==k){
                    if(carr[i]=='W'&&j+1<len){
                        if(countw.containsKey(i)) countw.put(i+1,countw.get(i)>0?countw.get(i)-1:0);
                    }
                    else
                        if(countw.containsKey(i))
                        countw.put(i+1,countw.get(i));
                    i++;

                }
            j++;
        }
        
        if(!countw.isEmpty()){
            int min=Integer.MAX_VALUE;
        Collection<Integer>count=countw.values();
        for(int val:count){
            min=Math.min(min,val);
        }
        return min;
        }
        return 0;
    }
}