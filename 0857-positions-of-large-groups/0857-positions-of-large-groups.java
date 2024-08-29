class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();
        char[] chars = s.toCharArray();
        int i=0,j=0,count=0;
        while(j<chars.length){
            if(chars[i]==chars[j]) 
               count+=1;
            else{
                if(count>=3)
                  list.add(List.of(i,j-1));
                i=j;
                count = 0;
                continue;
            }
            j++;
        }
        if(count>=3)
           list.add(List.of(i,j-1));
        list.sort((a,b)->a.get(0)-b.get(0));
        return list;
    }
}