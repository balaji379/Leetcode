class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
         Node root = new Node();
         for (int val : arr2){
            root.insert(String.valueOf(val),root);
         }
         int max = 0;
         for (int val : arr1){
           int ans =  root.prefixDeep(root,String.valueOf(val));
           max = Math.max(max,ans);
         }
         return max;
    }

    class Node{
        Node[] links;
        boolean flag;
        Node(){
            links = new Node[10];
            flag = false;
        }
        public void put(char c){
            links[c-'0'] = new Node();
        }
        public boolean containsNode(char c){
            return links[c-'0'] != null;
        }
        public boolean isEnd(){
            return flag;
        }
        public void setEnd(){
            flag = true;
        }
        public Node nextNode(char c){
            return links[c-'0'];
        }
        public void insert(String s,Node root){
            Node node = root;
            int len = s.length();
            for (int i = 0; i < len; i++){
                char c = s.charAt(i);
                if (!node.containsNode(c))
                     node.put(c);
                node = node.nextNode(c);
            }
            node.setEnd();
        }
        public int prefixDeep(Node root,String s){
            int count = 0,len = s.length();
            Node node = root;
            for (int i = 0; i < len; i++){
                char c = s.charAt(i);
                if (node.containsNode(c)){
                    node = node.nextNode(c);
                    count += 1;
                }
                 else return count;
            }
            return count;
        }
    }
}