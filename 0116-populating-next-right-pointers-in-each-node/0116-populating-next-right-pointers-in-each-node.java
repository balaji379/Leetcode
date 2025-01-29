/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        return SettingNext(root);
    }
    public  Node SettingNext(Node node){
        if (node == null)
             return node;
        List<List<Node>> level = new ArrayList<>();
        List<Node> queue = new LinkedList<>();
        List<Node> separateLevel = new LinkedList<>();
        queue.add(node);
        separateLevel.add(node);
        int pow = 0;
        double levelCount = Math.pow(2,pow);
        while(!queue.isEmpty()){

            if (levelCount == separateLevel.size() ){
                level.add(separateLevel);
                separateLevel = new LinkedList<>();
                levelCount = Math.pow(2,++pow);
            }

            Node temp = queue.removeFirst();
            if (temp.left != null) {
                queue.add(temp.left);
                separateLevel.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
                separateLevel.add(temp.right);
            }
        }
    //    System.out.println(level);
        for (List<Node> list : level){
            for (int i = 0; i < list.size() - 1; i++){
                   list.get(i).next = list.get(i + 1);
            }
        }
        return node;
    }
}