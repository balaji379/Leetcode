/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
       List<Integer> visited = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        Set<String> set = new HashSet<>();
        List<TreeNode> nodeList = new ArrayList<>();
        formUniqueBst(1, n, visited, set,nodeList);
        return nodeList;
    }

    public  void formUniqueBst(int start, int end, List<Integer> visited, Set<String> set,List<TreeNode> nodeList) {
        if (visited.size() == end) {
            if (visited.size() >= 2){
                TreeNode node = new TreeNode(visited.get(0));
                for (int i = 1; i < visited.size(); i++){
                  node =   insertElement(visited.get(i),node);
                }
                String str = createStringPath(node,new StringBuilder()).toString();

                if (!set.contains(str)) {
                    set.add(str);
                    nodeList.add(node);
                }
            }else if (visited.size() == 1){
                TreeNode node = new TreeNode(visited.get(0));
                nodeList.add(node);
            }
            return;
        }

        for (int i = 0; i < visited.size() + 1; i++) {
            List<Integer> temp = new LinkedList<>();
            temp.addAll(visited);
            temp.add(i, start);
            formUniqueBst(start + 1, end, temp, set, nodeList);
        }

    }

     public TreeNode insertElement(int val,TreeNode node) {
        if (node == null)
            return new TreeNode(val);
        if (node.val < val)
            node.right = insertElement(val, node.right);
        else if (node.val > val)
            node.left = insertElement(val, node.left);
        return node;
    }

     public StringBuilder createStringPath(TreeNode node, StringBuilder answer) {
        if (node == null)
            return answer;
        answer.append(node.val);
        answer = createStringPath(node.left, answer);
        answer = createStringPath(node.right, answer);
        return answer;
    }
}