class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for(int[] i: queens) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i[0]);
            list.add(i[1]);
            set.add(list);
        }
        // right side
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(king[0]);
        temp.add(king[1]);
        for(int i = king[1]+1; i < 8; i++){
            temp.set(1,i);
            if(set.contains(temp)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(temp.get(0));
                list.add(temp.get(1));
                ans.add(list);
                break;
            }
        }
        // right-bottom mid
        temp.set(0,king[0]);
        temp.set(1,king[1]);
        int itr = king[0]+1;
        while(itr < 8 && temp.get(0) < 8 && temp.get(1) < 8){
            itr++;
            temp.set(0,temp.get(0)+1);
            temp.set(1,temp.get(1)+1);
            if(set.contains(temp)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(temp.get(0));
                list.add(temp.get(1));
                ans.add(list);
                break;
            }
        }
        // bottom
        temp.set(0,king[0]);
        temp.set(1,king[1]);
        for(int i = king[0]+1; i < 8; i++){
            temp.set(0,i);
            if(set.contains(temp)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(temp.get(0));
                list.add(temp.get(1));
                ans.add(list);
                break;
            }
        }
        // left-bottom
        temp.set(0,king[0]);
        temp.set(1,king[1]);
        itr = king[0]+1;
        while(itr < 8 && temp.get(0) < 8 && temp.get(1) < 8){
            itr++;
            temp.set(0,temp.get(0)+1);
            temp.set(1,temp.get(1)-1);
            if(set.contains(temp)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(temp.get(0));
                list.add(temp.get(1));
                ans.add(list);
                break;
            }
        }
        //left side
        temp.set(0,king[0]);
        temp.set(1,king[1]);
        for(int i = king[1]-1; i >= 0; i--){
            temp.set(1,i);
            if(set.contains(temp)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(temp.get(0));
                list.add(temp.get(1));
                ans.add(list);
                break;
            }
        }
        // left-top mid
        temp.set(0,king[0]);
        temp.set(1,king[1]);
        itr = king[0]-1;
        while(itr >= 0 && temp.get(0) < 8 && temp.get(1) < 8){
            itr--;
            temp.set(0,temp.get(0)-1);
            temp.set(1,temp.get(1)-1);
            if(set.contains(temp)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(temp.get(0));
                list.add(temp.get(1));
                ans.add(list);
                break;
            }
        }
        // top
        temp.set(0,king[0]);
        temp.set(1,king[1]);
        for(int i = king[0]-1; i >= 0; i--){
            temp.set(0,i);
            if(set.contains(temp)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(temp.get(0));
                list.add(temp.get(1));
                ans.add(list);
                break;
            }
        }
        //right-top mid
        temp.set(0,king[0]);
        temp.set(1,king[1]);
        itr = king[0]-1;
        while(itr >= 0 && temp.get(0) < 8 && temp.get(1) < 8){
            itr--;
            temp.set(0,temp.get(0)-1);
            temp.set(1,temp.get(1)+1);
            if(set.contains(temp)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(temp.get(0));
                list.add(temp.get(1));
                ans.add(list);
                break;
            }
        }
        return ans;
    }
}