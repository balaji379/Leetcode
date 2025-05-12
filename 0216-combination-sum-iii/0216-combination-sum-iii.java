class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
         List<List<Integer>> list = new ArrayList<>();
         List<Integer> temp = new ArrayList<>();
         solve(list,temp,0,1,n,k);
         return list;
    }
    public void solve(List<List<Integer>> list,List<Integer> temp,int sum,int val,int n,int k){


        if (sum == n && temp.size() == k){
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = val; i <= 9; i++){
            if (sum + i > n)
               break;
            temp.add(i);
            solve(list,temp,sum + i,i + 1,n,k);
            temp.remove(temp.size() - 1);
        }
    }
}