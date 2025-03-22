import java.util.*;
class Main {
    public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr [] = new int [n];
    for(int i=0;i<n;i++){
    arr[i] = sc.nextInt();    
    } 
    int k = sc.nextInt();
    Solution obj = new Solution();
    obj.twoSum(arr,k);
    }
}
class Solution {
    public int[] twoSum(int[] num, int k){
    int n = num.length;
    for(int i=0;i<n-1;i++){
       for(int j=i+1;j<n;j++){
        if(num[i]+num[j]==k){
            return new int[]{i,j};
        }
       } 
    }
    return new int[]{};
}
}