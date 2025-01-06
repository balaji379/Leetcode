class Solution {
    public List<List<Integer>> threeSum(int[] num) {
           int index = 0;
           Arrays.sort(num);
        List<List<Integer>> ans = new LinkedList<>();
        if(num[0]==0 && num[num.length-1]==0 ){
            ans.add(List.of(0,0,0));
            return ans;
        }
        HashMap<Integer,Integer> list = new HashMap<Integer,Integer>();
        for(int i= 0 ; i<num.length ;i++){
            list.put(num[i],i);
        }
        HashSet<String> set = new HashSet<>();
        for(int i = 0;i<num.length ;i++){

            for(int j = i+1 ;j<num.length ;j++){

                 int third =  num[i]+num[j];
                 if(third>0) third*=-1;
                 else third = Math.abs(third);
                 boolean addlist_to_ans =true;
                  if(list.containsKey(third)){
                    if(list.get(third)!=i && list.get(third)!=j){
                        List<Integer > l = new  LinkedList<Integer>();
                        l.addAll(List.of(num[i],num[j],num[list.get(third)]));
                        l.sort((a,b)->Integer.compare(a,b));
                        String str  =l.toString();
                        if(!set.contains(str)) {
                            ans.add(l);
                            set.add(str);
                        }

                    }
                  }

            }

        }
        return ans;
    } 
    }
