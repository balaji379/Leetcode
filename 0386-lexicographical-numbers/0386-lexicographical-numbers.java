class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        Node root = new Node();
         for (int i = 1; i <= n; i++){
              insert(String.valueOf(i),root);
         }
         for (int i = 1; i <= 9; i++){
            if (root.links[i] != null){
                retrive(String.valueOf(i),root.links[i]);
            }
         }
         return res;
    }
    public void insert(String word,Node root){
        int len = word.length();
        for (int i = 0; i < len; i++){
            char c = word.charAt(i);
            if (!root.contains(c))
                root.put(c);
            root = root.nextNode(c);
        }
        root.setEnd();
    }
    public void retrive(String a , Node node){

       if (node.isEnd()){
          res.add(Integer.parseInt(a));
       }

        for (int i = 0; i < 10; i++){
            if (node.links[i] != null){
                 retrive(a + String.valueOf(i),node.nextNodeForInt(i));
            }
        }
    }
}
class Node{
    Node[] links = new Node[10];
    boolean flag = false;
    public void put(char c){
        if (links[c-'0'] == null)
            links[c-'0'] = new Node();
    }
    public Node nextNode(char c){
        return links[c-'0'];
    }
    public Node nextNodeForInt(int i){
        return links[i];
    }
    public boolean contains(char c){
        return links[c-'0'] != null;
    }

    public boolean isEnd(){
        return flag;
    }

    public void setEnd(){
        this.flag = true;
    }
}