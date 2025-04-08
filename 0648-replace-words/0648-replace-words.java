class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
         String[] s = sentence.split(" ");
         Node root = new Node();
         for (String word : dictionary){
            root.insert(word,root);
         }
         Map<String,String> map = new HashMap<>();
         for (int i = 0; i < s.length; i++){
            String res = root.isPresent(s[i],root);
            if (!res.isEmpty()){
                s[i] = res;
            }
         }
         StringBuilder sb = new StringBuilder();
         for (String word : s){
            sb.append(word+" ");
         }
         return sb.toString().trim(); 
    }
    class Node{
        Node[] links;
        boolean flag;
        Node(){
            links = new Node[27];
            flag = false;
        }
        public void put(char c){
          links[c-'a'] = new Node();
        }
        public boolean containsNode(char c){
            return links[c-'a'] != null;
        }
        public void setEnd(){
            this.flag = true;
        }
        public boolean isEnd(){
            return flag;
        }
        public Node nextNode(char c){
            return links[c-'a'];
        }

        public void insert(String s,Node root){
            int len = s.length();
            Node node = root;
            
            for (int i = 0; i < len; i++){
                char c = s.charAt(i);
                if (!node.containsNode(c)){
                    node.put(c);
                }
                node = node.nextNode(c);
            }
            node.setEnd();
        }
        public String isPresent(String s,Node root){
             int len = s.length();
            Node node = root;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++){
                char c = s.charAt(i);
                if (node.containsNode(c)){
                   node = node.nextNode(c);
                   sb.append(c);
                   if (node.isEnd())
                      return sb.toString();
                }
                else return "";
            }
            return "";
        }
    }
}